package blood.bank.infra.mappers;

import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.models.DonationEntity;

public class BloodBagEntityMapper {

    public static BloodBagEntity toEntity(BloodBag bloodBag){
        DonationEntity donationEntity = DonationEntityMapper.toEntity(bloodBag.getDonation());
        return new BloodBagEntity(donationEntity, bloodBag.getBloodType(), bloodBag.getBloodComponent(), bloodBag.getBagVolume(), bloodBag.getCollectionDate(), bloodBag.getExpirationDate(), bloodBag.getBagStatus(), bloodBag.getTestResult(), bloodBag.getFreezerNumber(), bloodBag.getBatchCode(), bloodBag.getComplianceStatus(), bloodBag.getNotes(), bloodBag.getProcessingDate());
    }

    public static BloodBag toBloodBag(BloodBagEntity bloodBagEntity){
        Donation donation = DonationEntityMapper.toDonation(bloodBagEntity.getDonation());
        return new BloodBag(donation, bloodBagEntity.getBloodType(), bloodBagEntity.getBloodComponent(), bloodBagEntity.getBagVolume(), bloodBagEntity.getCollectionDate(), bloodBagEntity.getExpirationDate(), bloodBagEntity.getBagStatus(), bloodBagEntity.getTestResult(), bloodBagEntity.getFreezerNumber(), bloodBagEntity.getBatchCode(), bloodBagEntity.getComplianceStatus(), bloodBagEntity.getNotes(), bloodBagEntity.getProcessingDate());
    }
}
