package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonationRepositoryGateway;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.mappers.DonationEntityMapper;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.repositories.DonationRepository;
import blood.bank.infra.persistence.repositories.DonorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonationRepositoryJpa implements DonationRepositoryGateway {

    private final DonationRepository donationRepository;


    public DonationRepositoryJpa(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> getDonations() {
        List<DonationEntity> donationEntities = this.donationRepository.findAll();
        return donationEntities.stream().map(DonationEntityMapper::toDonation).collect(Collectors.toList());
    }
}
