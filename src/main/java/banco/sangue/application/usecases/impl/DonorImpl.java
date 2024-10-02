package banco.sangue.application.usecases.impl;

import banco.sangue.application.repositories.DonorRepository;
import banco.sangue.application.usecases.DonorGateway;
import banco.sangue.infrastructure.adapters.http.models.response.DonorResponse;
import banco.sangue.infrastructure.persistence.entities.DonorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorImpl implements DonorGateway {

    private final DonorRepository donorRepository;

    public DonorImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<DonorResponse> getDonors() {
        List<DonorEntity> donors = donorRepository.findAll();
        return DonorResponse.convert(donors);
    }

    @Override
    public DonorResponse getDonorById(Long id) {
        return null;
    }

    @Override
    public DonorResponse createDonor(DonorResponse donor) {
        return null;
    }

    @Override
    public DonorResponse updateDonor(Long id, DonorResponse donor) {
        return null;
    }

    @Override
    public void deleteDonor(Long id) {

    }
}
