package blood.bank.infra.models.responses;


import blood.bank.domain.entities.scheduling.Scheduling;

import java.time.LocalDateTime;

public class SchedulingResponse {

    private DonorResponse donor;

    private LocalDateTime dateTimeSchedule;

    private String status;

    private String observations;

    private boolean canceled;

    public SchedulingResponse(Scheduling scheduling){
        this.donor = new DonorResponse(scheduling.getDonor());
        this.dateTimeSchedule = scheduling.getDateTimeSchedule();
        this.status = scheduling.getStatus();
        this.observations = scheduling.getObservations();
        this.canceled = scheduling.isCanceled();
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
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
