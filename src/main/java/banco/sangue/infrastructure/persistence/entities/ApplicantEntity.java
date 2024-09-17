package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "solicitante")
public class ApplicantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_solicitante")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PeopleEntity people;
}
