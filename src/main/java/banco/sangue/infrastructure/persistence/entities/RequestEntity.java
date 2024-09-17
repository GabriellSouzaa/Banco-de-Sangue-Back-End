package banco.sangue.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "solicitacao")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_solicitacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PatientEntity patient;

    private LocalDateTime requestDate;

    private String requestedType;

    private String requestedComponent;

    private BigDecimal requestedQuantity;

    private LocalDate needByDate;

    private LocalDateTime fulfillmentDate;

}
