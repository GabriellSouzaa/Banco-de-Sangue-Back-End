package banco.sangue.infrastructure.adapters.http.models.request;

import banco.sangue.infrastructure.persistence.entities.DonorEntity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DonorRequest {

    private PeopleRequest people;

    private String bloodType;

    private LocalDate registerDate;

    private LocalDate lastDonationDate;

    private Long numberOfDonations;

    private Boolean eligibility;

    private String medicalNotes;

    private Long bCoinsBalance;

    private String image;

    private BadgeRequest[] badges;

    public DonorEntity convert(DonorEntity donorEntity) {
        donorEntity.setPeople(this.people.convert(donorEntity.getPeople()));
        donorEntity.setBloodType(this.bloodType);
        donorEntity.setRegisterDate(this.registerDate);
        donorEntity.setLastDonationDate(this.lastDonationDate);
        donorEntity.setNumberOfDonations(this.numberOfDonations);
        donorEntity.setEligibility(this.eligibility);
        donorEntity.setMedicalNotes(this.medicalNotes);
        donorEntity.setBCoinsBalance(this.bCoinsBalance);
        donorEntity.setImage(this.image);
        return donorEntity;
    }
}
