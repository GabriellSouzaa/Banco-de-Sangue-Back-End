package blood.bank.infra.persistence.models;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_solicitacao")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id_paciente")
    private PatientEntity patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitante_id_solicitante")
    private ApplicantEntity applicant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id_funcionario")
    private EmployeeEntity employee;

    @Column(name = "data_solicitacao")
    private LocalDateTime requestDate;

    @Column(name = "tipo_solicitado")
    private String requestedType;

    @Column(name = "componente_solicitado")
    private String requestedComponent;

    @Column(name = "quantidade_solicitada")
    private BigDecimal requestedQuantity;

    @Column(name = "data_necessidade")
    private LocalDate needByDate;

    @Column(name = "data_atendimento")
    private LocalDateTime fulfillmentDate;

    @Column(name = "parecer")
    private String opinion;

    public RequestEntity(PatientEntity patient, ApplicantEntity applicant, EmployeeEntity employee, LocalDateTime requestDate, String requestedType, String requestedComponent, BigDecimal requestedQuantity, LocalDate needByDate, LocalDateTime fulfillmentDate, String opinion) {
        this.patient = patient;
        this.applicant = applicant;
        this.employee = employee;
        this.requestDate = requestDate;
        this.requestedType = requestedType;
        this.requestedComponent = requestedComponent;
        this.requestedQuantity = requestedQuantity;
        this.needByDate = needByDate;
        this.fulfillmentDate = fulfillmentDate;
        this.opinion = opinion;
    }

    public RequestEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public ApplicantEntity getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantEntity applicant) {
        this.applicant = applicant;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestedType() {
        return requestedType;
    }

    public void setRequestedType(String requestedType) {
        this.requestedType = requestedType;
    }

    public String getRequestedComponent() {
        return requestedComponent;
    }

    public void setRequestedComponent(String requestedComponent) {
        this.requestedComponent = requestedComponent;
    }

    public BigDecimal getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(BigDecimal requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public LocalDate getNeedByDate() {
        return needByDate;
    }

    public void setNeedByDate(LocalDate needByDate) {
        this.needByDate = needByDate;
    }

    public LocalDateTime getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(LocalDateTime fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
