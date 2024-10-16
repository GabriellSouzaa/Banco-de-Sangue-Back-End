package blood.bank.domain.entities.request;

import blood.bank.domain.entities.patient.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Request {

    private Patient patient;

    private LocalDateTime requestDate;

    private String requestedType;

    private String requestedComponent;

    private BigDecimal requestedQuantity;

    private LocalDate needByDate;

    private LocalDateTime fulfillmentDate;
}
