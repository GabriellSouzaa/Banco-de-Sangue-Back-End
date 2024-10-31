package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorBadgeRepositoryGateway;
import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.mappers.DonorBadgeEntityMapper;
import blood.bank.infra.models.requests.GrantDonorBadgeRequest;
import blood.bank.infra.persistence.models.BadgeEntity;
import blood.bank.infra.persistence.models.DonorBadgeEntity;
import blood.bank.infra.persistence.models.DonorBadgeId;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.repositories.BadgeRepository;
import blood.bank.infra.persistence.repositories.DonorBadgeRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DonorBadgeRepositoryJpa implements DonorBadgeRepositoryGateway {

    private final DonorBadgeRepository donorBadgeRepository;

    private final DonorBadgeEntityMapper donorBadgeEntityMapper;

    private final DonorRepository donorRepository;

    private final BadgeRepository badgeRepository;

    public DonorBadgeRepositoryJpa(DonorBadgeRepository donorBadgeRepository, DonorBadgeEntityMapper donorBadgeEntityMapper, DonorRepository donorRepository, BadgeRepository badgeRepository) {
        this.donorBadgeRepository = donorBadgeRepository;
        this.donorBadgeEntityMapper = donorBadgeEntityMapper;
        this.donorRepository = donorRepository;
        this.badgeRepository = badgeRepository;
    }

    @Override
    public List<DonorBadge> getDonorBadgesByDonorId(Long donorId) {
        List<DonorBadgeEntity> donorBadgeEntities = this.donorBadgeRepository.findDonorBadgeEntitiesByDonor_Id(donorId);
        return donorBadgeEntities.stream().map(DonorBadgeEntityMapper::toDonorBadgeEntity).collect(Collectors.toList());
    }

    @Override
    public void grantDonorBadge(GrantDonorBadgeRequest grantDonorBadgeRequest) {
        DonorBadgeEntity donorBadgeEntity = new DonorBadgeEntity();

        DonorEntity donor = donorRepository.findById(grantDonorBadgeRequest.getDonorId())
                .orElseThrow(() -> new IllegalArgumentException("Doador não encontrado"));

        BadgeEntity badge = badgeRepository.findBadgeEntityByBadgeName(grantDonorBadgeRequest.getBadgeName());

        DonorBadgeId donorBadgeId = new DonorBadgeId(donor.getId(), badge.getId());

        donorBadgeEntity.setDonorBadgeId(donorBadgeId);
        donorBadgeEntity.setDonor(donor);
        donorBadgeEntity.setBadgeEntity(badge);
        donorBadgeEntity.setAchievementDate(LocalDate.now());

        donorBadgeRepository.save(donorBadgeEntity);
    }
}
