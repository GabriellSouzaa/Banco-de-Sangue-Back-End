package banco.sangue.infrastructure.adapters.http.models.response;

import banco.sangue.infrastructure.persistence.entities.PeopleEntity;

import java.time.LocalDate;

public record PeopleResponse(String fullName, LocalDate dateOfBirth, String gender, String email) {

    public PeopleResponse(PeopleEntity peopleEntity) {
        this(peopleEntity.getFullName(), peopleEntity.getDateOfBirth(), peopleEntity.getGender(), peopleEntity.getEmail());
    }
}
