package blood.bank.application.gateways;

import blood.bank.domain.entities.bloodBag.BloodBag;

import java.util.List;

public interface BloodBagRepositoryGateway {
    List<BloodBag> getBloodBags();
}
