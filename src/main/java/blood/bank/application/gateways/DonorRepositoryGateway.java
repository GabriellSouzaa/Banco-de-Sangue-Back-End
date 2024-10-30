package blood.bank.application.gateways;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.persistence.models.DonorEntity;

import java.util.List;

public interface DonorRepositoryGateway {

    List<Donor> getDonors();

    Donor awardPoints(String donorFullName, String donorEmail, Long points);

    List<Donor> getAvailableDonors();

    boolean isDonorElegible(DonorEntity donor);
}
