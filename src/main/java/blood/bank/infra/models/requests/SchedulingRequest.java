package blood.bank.infra.models.requests;

import blood.bank.infra.persistence.models.DonorEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class SchedulingRequest {


    private DonorRequest donor;

    private LocalDateTime dateTimeSchedule;

    private String status;

    private String observations;

    private boolean canceled;

    public DonorRequest getDonor() {
        return donor;
    }

    public void setDonor(DonorRequest donor) {
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
