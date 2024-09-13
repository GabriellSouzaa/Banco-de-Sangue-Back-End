package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "insignia")
public class BadgeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_insigna")
    private Long id;

    @Column(name = "nome_insigna")
    private String badgeName;

    @Column(name = "imagem")
    private String image;

    @Column(name = "pontos_necessarios")
    private Integer necessaryPoints;

    @Column(name = "data_conquista")
    private LocalDate dateOfAchievement;
}
