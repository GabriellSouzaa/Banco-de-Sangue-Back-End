package blood.bank.infra.models.requests;

import blood.bank.infra.persistence.models.AddressEntity;
import jakarta.persistence.Column;

public class BloodCenterRequest {

    private AddressRequest address;

    private String bloodCenterName;

    private String email;

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public void setBloodCenterName(String bloodCenterName) {
        this.bloodCenterName = bloodCenterName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
