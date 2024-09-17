package banco.sangue.infrastructure.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "solicitacao_hospital_clinica")
public class RequestHospitalClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_solicitacao_hospital_clinica")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private HospitalClinicEntity hospitalClinic;

    private LocalDateTime requestDate;

    private String requestedBloodType;

    private String requestedBloodComponent;

    private Integer requestedQuantity;

    private LocalDate needByDate;

    private String requestStatus;

    private Integer observation;

}
