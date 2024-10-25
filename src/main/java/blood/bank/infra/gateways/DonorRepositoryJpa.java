package blood.bank.infra.gateways;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.mappers.DonorMapper;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.repositories.DonorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DonorRepositoryJpa implements DonorRepositoryGateway {

    private final DonorRepository donorRepository;

    private final DonorMapper donorMapper;

    public DonorRepositoryJpa(DonorRepository donorRepository, DonorMapper donorMapper) {
        this.donorRepository = donorRepository;
        this.donorMapper = donorMapper;
    }

    @Override
    public List<Donor> getDonors() {
        List<DonorEntity> donors = donorRepository.findAll();
        return donors.stream().map(DonorMapper::toDonor).collect(Collectors.toList());
    }

    @Override
    public Donor awardPoints(String donorFullName, String donorEmail, Long points) {
        DonorEntity donorEntity = donorRepository.findDonorEntityByPeople_FullNameAndPeople_Email(donorFullName, donorEmail);
        donorEntity.setbCoinsBalance(donorEntity.getbCoinsBalance() + points);
        return DonorMapper.toDonor(donorRepository.save(donorEntity));
    }
}
