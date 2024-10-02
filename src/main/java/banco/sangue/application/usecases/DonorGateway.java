package banco.sangue.application.usecases;

import banco.sangue.infrastructure.adapters.http.models.response.DonorResponse;

import java.util.List;
public interface DonorGateway {

    List<DonorResponse> getDonors();

    DonorResponse getDonorById(Long id);

    DonorResponse createDonor(DonorResponse donor);

    DonorResponse updateDonor(Long id, DonorResponse donor);

    void deleteDonor(Long id);
}

