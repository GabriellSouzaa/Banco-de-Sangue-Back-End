package blood.bank.domain.entities.hospitalClinic;

import blood.bank.domain.entities.address.Address;

public class HospitalClinic {

    private Long id;

    private Address address;

    private String name;

    private String phone;

    private String email;

    public HospitalClinic(Long id, Address address, String name, String phone, String email) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
