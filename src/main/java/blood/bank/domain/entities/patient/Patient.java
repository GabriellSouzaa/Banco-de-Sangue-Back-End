package blood.bank.domain.entities.patient;

import blood.bank.domain.entities.people.People;

public class Patient {

    private People people;

    private String cpf;

    private String phone;

    private String bloodType;

    private String medicalHistory;

    private String healthPlanNumber;

    private String observations;

    public Patient(People people, String cpf, String phone, String bloodType, String medicalHistory, String healthPlanNumber, String observations) {
        this.people = people;
        this.cpf = cpf;
        this.phone = phone;
        this.bloodType = bloodType;
        this.medicalHistory = medicalHistory;
        this.healthPlanNumber = healthPlanNumber;
        this.observations = observations;
    }

    public Patient() {
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
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
