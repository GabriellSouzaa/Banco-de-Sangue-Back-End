package blood.bank.domain.entities.request;

import blood.bank.domain.entities.applicant.Applicant;
import blood.bank.domain.entities.employee.Employee;
import blood.bank.domain.entities.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Request {

    private Patient patient;

    private Applicant applicant;

    private Employee employee;

    private LocalDateTime requestDate;

    private String requestedType;

    private String requestedComponent;

    private BigDecimal requestedQuantity;

    private LocalDate needByDate;

    private LocalDateTime fulfillmentDate;

    private String opinion;

    public Request(Patient patient, Applicant applicant, Employee employee, LocalDateTime requestDate, String requestedType, String requestedComponent, BigDecimal requestedQuantity, LocalDate needByDate, LocalDateTime fulfillmentDate, String opinion) {
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

    public Request() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
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
