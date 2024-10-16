package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital_clinica")
public class HospitalClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hospital_clinica")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    private String name;

    private String phone;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
