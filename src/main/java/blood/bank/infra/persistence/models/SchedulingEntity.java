package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento_doacao")
public class SchedulingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doador_id")
    private DonorEntity donor;

    @Column(name = "data_hora_agendamento")
    private LocalDateTime dateTimeSchedule;

    @Column(name = "status")
    private String status;

    @Column(name = "observacoes")
    private String observations;

    @Column(name = "cancelado")
    private boolean canceled;

    public SchedulingEntity(DonorEntity donor, LocalDateTime dateTimeSchedule, String status, String observations, boolean canceled) {
        this.donor = donor;
        this.dateTimeSchedule = dateTimeSchedule;
        this.status = status;
        this.observations = observations;
        this.canceled = canceled;
    }

    public SchedulingEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DonorEntity getDonor() {
        return donor;
    }

    public void setDonor(DonorEntity donor) {
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
