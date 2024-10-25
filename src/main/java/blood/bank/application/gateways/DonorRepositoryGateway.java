package blood.bank.application.gateways;

import blood.bank.domain.entities.donor.Donor;

import java.util.List;

public interface DonorRepositoryGateway {

    List<Donor> getDonors();

    Donor awardPoints(String donorFullName, String donorEmail, Long points);
}
