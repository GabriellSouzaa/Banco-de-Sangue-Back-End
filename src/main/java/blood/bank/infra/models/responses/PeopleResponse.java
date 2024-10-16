package blood.bank.infra.models.responses;

import blood.bank.domain.entities.people.People;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class PeopleResponse {


    private String fullName;

    private LocalDate dateOfBirth;

    private String gender;

    private String email;

    public PeopleResponse(People people) {
        this.fullName = people.getFullName();
        this.gender = people.getGender();
        this.dateOfBirth = people.getDateOfBirth();
        this.email = people.getEmail();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
