package blood.bank.domain.entities.scheduling;

import blood.bank.domain.entities.donor.Donor;

import java.time.LocalDateTime;

public class Scheduling {

    private Long id;



    private Donor donor;

    private LocalDateTime dateTimeSchedule;

    private String status;

    private String observations;

    private boolean canceled;

    public Scheduling(Donor donor, Long id, LocalDateTime dateTimeSchedule, String status, String observations, boolean canceled) {
        this.id = id;
        this.donor = donor;
        this.dateTimeSchedule = dateTimeSchedule;
        this.status = status;
        this.observations = observations;
        this.canceled = canceled;
    }

    public Scheduling() {
    }

    public Scheduling(Donor donor, LocalDateTime dateTimeSchedule, String status, String observations, boolean canceled) {
        this.donor = donor;
        this.dateTimeSchedule = dateTimeSchedule;
        this.status = status;
        this.observations = observations;
        this.canceled = canceled;
    }

    public Long getId() {
        return id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public LocalDateTime getDateTimeSchedule() {
        return dateTimeSchedule;
    }

    public void setDateTimeSchedule(LocalDateTime dateTimeSchedule) {
        this.dateTimeSchedule = dateTimeSchedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
