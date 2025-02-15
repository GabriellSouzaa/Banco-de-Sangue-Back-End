package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital_clinica")
public class HospitalClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_seq")
    @SequenceGenerator(name = "hospital_seq", sequenceName = "hospital_clinica_id_seq", allocationSize = 1)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_endereco")
    private AddressEntity address;

    @Column(name = "nome")
    private String name;

    @Column(name = "telefone")
    private String phone;

    private String email;

    public HospitalClinicEntity(Long id, AddressEntity addressEntity, String name, String phone, String email) {
        this.id = id;
        this.address = addressEntity;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public HospitalClinicEntity() {

    }

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
