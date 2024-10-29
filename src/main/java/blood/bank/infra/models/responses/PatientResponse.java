package blood.bank.infra.models.responses;

import blood.bank.domain.entities.patient.Patient;

public class PatientResponse {

    private PeopleResponse people;

    private String cpf;

    private String phone;

    private String bloodType;

    private String medicalHistory;

    private String healthPlanNumber;

    private String observations;

    public PatientResponse(Patient patient){
        this.people = new PeopleResponse(patient.getPeople());
        this.cpf = patient.getCpf();
        this.phone = patient.getPhone();
        this.bloodType = patient.getBloodType();
        this.medicalHistory = patient.getMedicalHistory();
        this.healthPlanNumber = patient.getHealthPlanNumber();
        this.observations = patient.getObservations();
    }

    public PeopleResponse getPeople() {
        return people;
    }

    public void setPeople(PeopleResponse people) {
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
