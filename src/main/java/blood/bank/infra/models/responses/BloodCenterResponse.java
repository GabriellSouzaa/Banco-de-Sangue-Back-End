package blood.bank.infra.models.responses;

import blood.bank.domain.entities.address.Address;
import blood.bank.domain.entities.bloodCenter.BloodCenter;


public class BloodCenterResponse {

    private Address address;

    private String bloodCenterName;

    private String email;

    public BloodCenterResponse(BloodCenter bloodCenter) {
        this.address = bloodCenter.getAddress();
        this.bloodCenterName = bloodCenter.getBloodCenterName();
        this.email = bloodCenter.getEmail();
    }

    public Address getAddress() {
        return address;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public String getEmail() {
        return email;
    }
}
