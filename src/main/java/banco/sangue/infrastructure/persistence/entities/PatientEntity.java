package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "paciente")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paciente")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PeopleEntity people;

    private String cpf;

    private String phone;

    private String bloodType;

    private String medicalHistory;

    private String healthPlanNumber;

    private String observations;

}
