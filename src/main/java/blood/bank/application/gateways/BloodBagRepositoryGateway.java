package blood.bank.application.gateways;

import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.models.requests.BloodBagRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BloodBagRepositoryGateway {
    List<BloodBag> getBloodBags();

    void deleteExpiredBloodBags();

    void createBloodBag(BloodBagRequest bloodBagRequest);

    void updateBloodBag(String batchCode, BloodBagRequest bloodBagRequest);

    void deleteBloodBag(String batchCode);

    ResponseEntity<byte[]> generateReportBloodBag();
}
