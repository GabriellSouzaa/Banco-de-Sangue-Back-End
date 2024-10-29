package blood.bank.infra.models.responses;

import blood.bank.domain.entities.request.Request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestResponse {

    private PatientResponse patient;

    private ApplicantResponse applicant;

    private EmployeeResponse employee;

    private LocalDateTime requestDate;

    private String requestedType;

    private String requestedComponent;

    private BigDecimal requestedQuantity;

    private LocalDate needByDate;

    private LocalDateTime fulfillmentDate;

    public RequestResponse(Request request) {
        this.patient = new PatientResponse(request.getPatient());
        this.applicant = new ApplicantResponse(request.getApplicant());
        this.employee = new EmployeeResponse(request.getEmployee());
        this.requestDate = request.getRequestDate();
        this.requestedType = request.getRequestedType();
        this.requestedComponent = request.getRequestedComponent();
        this.requestedQuantity = request.getRequestedQuantity();
        this.needByDate = request.getNeedByDate();
        this.fulfillmentDate = request.getFulfillmentDate();
    }

    public PatientResponse getPatient() {
        return patient;
    }

    public void setPatient(PatientResponse patient) {
        this.patient = patient;
    }

    public ApplicantResponse getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantResponse applicant) {
        this.applicant = applicant;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
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
}
