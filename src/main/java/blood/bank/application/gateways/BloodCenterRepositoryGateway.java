package blood.bank.application.gateways;

import blood.bank.domain.entities.bloodCenter.BloodCenter;

import java.util.List;

public interface BloodCenterRepositoryGateway {

    List<BloodCenter> getBloodCenters();
}
