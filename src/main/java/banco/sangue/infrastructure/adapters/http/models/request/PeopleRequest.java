package banco.sangue.infrastructure.adapters.http.models.request;

import banco.sangue.infrastructure.persistence.entities.PeopleEntity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PeopleRequest {
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;

    public PeopleEntity convert(PeopleEntity peopleEntity) {
        peopleEntity.setFullName(this.fullName);
        peopleEntity.setDateOfBirth(this.dateOfBirth);
        peopleEntity.setGender(this.gender);
        peopleEntity.setEmail(this.email);
        return peopleEntity;
    }
}
