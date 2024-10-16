package blood.bank.infra.persistence.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HospitalClinicEntity getHospitalClinic() {
        return hospitalClinic;
    }

    public void setHospitalClinic(HospitalClinicEntity hospitalClinic) {
        this.hospitalClinic = hospitalClinic;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestedBloodType() {
        return requestedBloodType;
    }

    public void setRequestedBloodType(String requestedBloodType) {
        this.requestedBloodType = requestedBloodType;
    }

    public String getRequestedBloodComponent() {
        return requestedBloodComponent;
    }

    public void setRequestedBloodComponent(String requestedBloodComponent) {
        this.requestedBloodComponent = requestedBloodComponent;
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public LocalDate getNeedByDate() {
        return needByDate;
    }

    public void setNeedByDate(LocalDate needByDate) {
        this.needByDate = needByDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Integer getObservation() {
        return observation;
    }

    public void setObservation(Integer observation) {
        this.observation = observation;
    }
}
