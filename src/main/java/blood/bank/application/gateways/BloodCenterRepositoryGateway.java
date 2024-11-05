package blood.bank.application.gateways;

import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.models.requests.BloodCenterRequest;

import java.util.List;

public interface BloodCenterRepositoryGateway {

    List<BloodCenter> getBloodCenters();

    void createBloodCenter(Long id, BloodCenterRequest bloodCenterRequest);

    void updateBloodCenter(Long id, BloodCenterRequest bloodCenterRequest);

    void deleteBloodCenter(Long id);
}
