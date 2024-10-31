package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorBadgeRepositoryGateway;
import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.mappers.DonorBadgeEntityMapper;
import blood.bank.infra.persistence.models.DonorBadgeEntity;
import blood.bank.infra.persistence.repositories.BadgeRepository;
import blood.bank.infra.persistence.repositories.DonorBadgeRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;

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
}
