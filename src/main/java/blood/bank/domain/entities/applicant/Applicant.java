package blood.bank.domain.entities.applicant;

import blood.bank.domain.entities.people.People;


public class Applicant {

    private Long id;

    private People people;

    public Applicant(People people) {
        this.people = people;
    }

    public Applicant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
