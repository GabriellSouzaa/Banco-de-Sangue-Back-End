package blood.bank.domain.entities.requestHospitalClinic;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestHospitalClinic {

    private Long id;

    private HospitalClinic hospitalClinic;

    private LocalDateTime requestDate;

    private String requestedBloodType;

    private String requestedBloodComponent;

    private Integer requestedQuantity;

    private LocalDate needByDate;

    private String requestStatus;

    private String observation;

    public RequestHospitalClinic(Long id, HospitalClinic hospitalClinic, LocalDateTime requestDate, String requestedBloodType, String requestedBloodComponent, Integer requestedQuantity, LocalDate needByDate, String requestStatus, String observation) {
        this.id = id;
        this.hospitalClinic = hospitalClinic;
        this.requestDate = requestDate;
        this.requestedBloodType = requestedBloodType;
        this.requestedBloodComponent = requestedBloodComponent;
        this.requestedQuantity = requestedQuantity;
        this.needByDate = needByDate;
        this.requestStatus = requestStatus;
        this.observation = observation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HospitalClinic getHospitalClinic() {
        return hospitalClinic;
    }

    public void setHospitalClinic(HospitalClinic hospitalClinic) {
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
