package blood.bank.domain.entities.bloodCenter;

import blood.bank.domain.entities.address.Address;


public class BloodCenter {

    private Long id;

    private Address address;

    private String bloodCenterName;

    private String email;

    public BloodCenter(Long id, Address address, String bloodCenterName, String email) {
        this.id = id;
        this.address = address;
        this.bloodCenterName = bloodCenterName;
        this.email = email;
    }

    public Long getId() {
        return id;
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
