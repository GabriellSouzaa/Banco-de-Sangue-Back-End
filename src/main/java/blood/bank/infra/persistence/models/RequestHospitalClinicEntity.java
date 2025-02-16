package blood.bank.infra.persistence.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao_hospital_clinica")
public class RequestHospitalClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitacao_hospital_clinica_id_seq")
    @SequenceGenerator(name = "solicitacao_hospital_clinica_id_seq", sequenceName = "solicitacao_hospital_clinica_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_clinica_id")
    private HospitalClinicEntity hospitalClinic;

    @Column(name = "data_solicitacao")
    private LocalDateTime requestDate;

    @Column(name = "tipo_sangue_solicitado")
    private String requestedBloodType;

    @Column(name = "componente_sangue_solicitado")
    private String requestedBloodComponent;

    @Column(name = "quantidade_solicitada")
    private Integer requestedQuantity;

    @Column(name = "data_de_necessidade")
    private LocalDate needByDate;

    @Column(name = "status_solicitacao")
    private String requestStatus;

    @Column(name = "observacao")
    private String observation;

    public RequestHospitalClinicEntity(Long id, HospitalClinicEntity hospitalClinicEntity, LocalDateTime requestDate, String requestedBloodType, String requestedBloodComponent, LocalDate needByDate, String requestStatus, String observation) {
        this.id = id;
        this.hospitalClinic = hospitalClinicEntity;
        this.requestDate = requestDate;
        this.requestedBloodType = requestedBloodType;
        this.requestedBloodComponent = requestedBloodComponent;
        this.needByDate = needByDate;
        this.requestStatus = requestStatus;
        this.observation = observation;
    }

    public RequestHospitalClinicEntity() {

    }


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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
