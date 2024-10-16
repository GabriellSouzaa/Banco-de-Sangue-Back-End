package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


@Entity
@Table(name = "hemocentro")
public class BloodCenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hemocentro")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    private String bloodCenterName;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public void setBloodCenterName(String bloodCenterName) {
        this.bloodCenterName = bloodCenterName;
    }
}
