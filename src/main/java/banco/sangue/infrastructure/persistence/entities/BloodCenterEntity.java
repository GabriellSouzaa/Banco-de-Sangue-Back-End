package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
