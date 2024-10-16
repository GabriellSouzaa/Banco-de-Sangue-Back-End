package blood.bank.infra.persistence.models;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paciente")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PeopleEntity people;

    private String cpf;

    private String phone;

    private String bloodType;

    private String medicalHistory;

    private String healthPlanNumber;

    private String observations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHealthPlanNumber() {
        return healthPlanNumber;
    }

    public void setHealthPlanNumber(String healthPlanNumber) {
        this.healthPlanNumber = healthPlanNumber;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
