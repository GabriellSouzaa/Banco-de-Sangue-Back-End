package blood.bank.domain.entities.bloodCenter;

import blood.bank.domain.entities.address.Address;


public class BloodCenter {

    private Address address;

    private String bloodCenterName;

    private String email;

    public BloodCenter(Address address, String bloodCenterName, String email) {
        this.address = address;
        this.bloodCenterName = bloodCenterName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public Address getAddress() {
        return address;
    }
}
