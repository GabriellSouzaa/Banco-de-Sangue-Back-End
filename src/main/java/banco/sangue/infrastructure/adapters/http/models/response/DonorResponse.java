package banco.sangue.infrastructure.adapters.http.models.response;

import java.time.LocalDate;

public record DonorResponse(PeopleResponse people, String bloodType, LocalDate registerDate, LocalDate lastDonationDate, Long numberOfDonations, Boolean eligibility, String medicalNotes, Long bCoinsBalance, String image, BadgeResponse[] badges) {

}
