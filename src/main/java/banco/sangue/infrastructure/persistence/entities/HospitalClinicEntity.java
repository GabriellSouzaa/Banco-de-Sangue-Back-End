package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
