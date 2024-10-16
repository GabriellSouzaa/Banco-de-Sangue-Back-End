package blood.bank.domain.entities.requestHospitalClinic;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestHospitalClinic {

    private HospitalClinic hospitalClinic;

    private LocalDateTime requestDate;

    private String requestedBloodType;

    private String requestedBloodComponent;

    private Integer requestedQuantity;

    private LocalDate needByDate;

    private String requestStatus;

    private Integer observation;
}
