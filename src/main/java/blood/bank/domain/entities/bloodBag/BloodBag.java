package blood.bank.domain.entities.bloodBag;

import blood.bank.domain.entities.donation.Donation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BloodBag {

    private List<Donation> donations;

    private String bloodType;

    private String bloodComponent;

    private String bagVolume;

    private LocalDate collectionDate;

    private LocalDate expirationDate;

    private String bagStatus;

    private String testResult;

    private String freezerNumber;

    private String batchCode;

    private String complianceStatus;

    private String notes;

    private LocalDateTime processingDate;
}
