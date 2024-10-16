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
    private PatientEntity patient;

    private LocalDateTime requestDate;

    private String requestedType;

    private String requestedComponent;

    private BigDecimal requestedQuantity;

    private LocalDate needByDate;

    private LocalDateTime fulfillmentDate;

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

    public BigDecimal getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(BigDecimal requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public String getRequestedComponent() {
        return requestedComponent;
    }

    public void setRequestedComponent(String requestedComponent) {
        this.requestedComponent = requestedComponent;
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
}
