package blood.bank.infra.mappers;

import blood.bank.domain.entities.donation.Donation;
import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.models.DonorEntity;

import java.time.LocalDate;

public class DonationEntityMapper {

    public static DonationEntity toEntity(Donation donation) {
        DonorEntity donorEntity = DonorMapper.toEntity(donation.getDonor());
        return new DonationEntity(donorEntity, donation.getDateDonation(), donation.getDonatioType(), donation.getQuantityCollected(),
                donation.getDonationStatus(), donation.getObservation(), donation.getDonationScore());
    }

    public static Donation toDonation(DonationEntity donationEntity){
        Donor donor = DonorMapper.toDonor(donationEntity.getDonor());
        return new Donation(donor, donationEntity.getDonatioType(), donationEntity.getDateDonation(), donationEntity.getQuantityCollected(),
                donationEntity.getDonationStatus(), donationEntity.getObservation(), donationEntity.getDonationScore());
    }
}
