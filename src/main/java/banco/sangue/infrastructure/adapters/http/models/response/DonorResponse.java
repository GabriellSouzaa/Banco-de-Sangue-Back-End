package banco.sangue.infrastructure.adapters.http.models.response;


import banco.sangue.infrastructure.persistence.entities.DonorEntity;

import java.time.LocalDate;
import java.util.List;

public record DonorResponse(PeopleResponse people, String bloodType, LocalDate registerDate, LocalDate lastDonationDate, Long numberOfDonations, Boolean eligibility, String medicalNotes, Long bCoinsBalance, String image, BadgeResponse[] badges) {
    public DonorResponse(DonorEntity donor){
        this(new PeopleResponse(donor.getPeople()), donor.getBloodType(), donor.getRegisterDate(), donor.getLastDonationDate(), donor.getNumberOfDonations(), donor.getEligibility(), donor.getMedicalNotes(), donor.getBCoinsBalance(), donor.getImage(), donor.getBadge().stream().map(BadgeResponse::new).toArray(BadgeResponse[]::new));
    }

    public static List<DonorResponse> convert(List<DonorEntity> donors){
        return donors.stream().map(DonorResponse::new).toList();
    }
}
