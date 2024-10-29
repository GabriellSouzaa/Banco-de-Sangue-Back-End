package blood.bank.infra.models.responses;

import blood.bank.domain.entities.applicant.Applicant;

public class ApplicantResponse {

    private PeopleResponse people;

    public ApplicantResponse(Applicant applicant) {
        this.people = new PeopleResponse(applicant.getPeople());
    }

    public PeopleResponse getPeople() {
        return people;
    }

    public void setPeople(PeopleResponse people) {
        this.people = people;
    }
}
