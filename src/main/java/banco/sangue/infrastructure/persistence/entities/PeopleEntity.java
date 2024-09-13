package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pessoa")
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "nome_completo")
    private String fullName;

    @Column(name = "data_nascimento")
    private LocalDate dateOfBirth;

    @Column(name = "genero")
    private String gender;

    private String email;
}
