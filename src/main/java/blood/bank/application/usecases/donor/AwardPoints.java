package blood.bank.application.usecases.donor;

import blood.bank.application.gateways.DonorRepositoryGateway;
import blood.bank.domain.entities.donor.Donor;

public class AwardPoints {

    private final DonorRepositoryGateway donorRepositoryGateway;

    public AwardPoints(DonorRepositoryGateway donorRepositoryGateway) {
        this.donorRepositoryGateway = donorRepositoryGateway;
    }

    public Donor awardPoints(String donorFullName, String donorEmail, Long points) {
        return donorRepositoryGateway.awardPoints(donorFullName, donorEmail, points);
    }
}
