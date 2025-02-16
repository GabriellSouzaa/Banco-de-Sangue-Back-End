package blood.bank.infra.models.responses;

import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestHospitalClinicResponse {

    private Long id;

    private LocalDateTime requestDate;

    private String requestedBloodType;

    private String requestedBloodComponent;

    private Integer requestedQuantity;

    private LocalDate needByDate;

    private String requestStatus;

    private String observation;

    private HospitalClinicResponse hospitalClinic;

    public RequestHospitalClinicResponse(RequestHospitalClinic requestHospitalClinic){
        this.id = requestHospitalClinic.getId();
        this.hospitalClinic = new HospitalClinicResponse(requestHospitalClinic.getHospitalClinic());
        this.requestDate = requestHospitalClinic.getRequestDate();
        this.requestedBloodType = requestHospitalClinic.getRequestedBloodType();
        this.requestedBloodComponent = requestHospitalClinic.getRequestedBloodComponent();
        this.requestedQuantity = requestHospitalClinic.getRequestedQuantity();
        this.needByDate = requestHospitalClinic.getNeedByDate();
        this.requestStatus = requestHospitalClinic.getRequestStatus();
        this.observation = requestHospitalClinic.getObservation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HospitalClinicResponse getHospitalClinic() {
        return hospitalClinic;
    }

    public void setHospitalClinic(HospitalClinicResponse hospitalClinic) {
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
