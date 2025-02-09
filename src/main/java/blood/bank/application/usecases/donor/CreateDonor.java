package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.models.requests.DonorRequest;
import org.springframework.web.multipart.MultipartFile;

public class CreateDonor {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public CreateDonor(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public Donor createDonor(DonorRequest donorRequest, MultipartFile photo) {
        return this.donorRepositoryGateway.createDonor(donorRequest, photo);
    }
}
