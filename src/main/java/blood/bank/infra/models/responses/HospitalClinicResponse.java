package blood.bank.infra.models.responses;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;

public class HospitalClinicResponse {

    private String name;

    private String phone;

    private String email;

    private AddressResponse address;

    public HospitalClinicResponse(HospitalClinic hospitalClinic){
        this.address = new AddressResponse(hospitalClinic.getAddress());
        this.name = hospitalClinic.getName();
        this.phone = hospitalClinic.getPhone();
        this.email = hospitalClinic.getEmail();
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
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
