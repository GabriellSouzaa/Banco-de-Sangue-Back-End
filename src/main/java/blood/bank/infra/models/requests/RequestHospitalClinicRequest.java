package blood.bank.infra.models.requests;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestHospitalClinicRequest {

    private Long hospitalClinicId;

    private LocalDateTime requestDate;

    private String requestedBloodType;

    private String requestedBloodComponent;

    private Integer requestedQuantity;

    private LocalDate needByDate;

    private String requestStatus;

    private String observation;

    public Long getHospitalClinicId() {
        return hospitalClinicId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public String getRequestedBloodType() {
        return requestedBloodType;
    }

    public String getRequestedBloodComponent() {
        return requestedBloodComponent;
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }

    public LocalDate getNeedByDate() {
        return needByDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public String getObservation() {
        return observation;
    }
}
