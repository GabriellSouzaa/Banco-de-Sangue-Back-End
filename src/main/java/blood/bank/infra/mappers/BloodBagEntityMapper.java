package blood.bank.infra.mappers;

import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.domain.entities.donation.Donation;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.models.DonationEntity;

import java.util.List;

public class BloodBagEntityMapper {

    public static BloodBagEntity toEntity(BloodBag bloodBag){
        List<DonationEntity> donationEntities = bloodBag.getDonations().stream()
                .map(DonationEntityMapper::toEntity).toList();
        return new BloodBagEntity(donationEntities, bloodBag.getBloodType(), bloodBag.getBloodComponent(), bloodBag.getBagVolume(), bloodBag.getCollectionDate(), bloodBag.getExpirationDate(), bloodBag.getBagStatus(), bloodBag.getTestResult(), bloodBag.getFreezerNumber(), bloodBag.getBatchCode(), bloodBag.getComplianceStatus(), bloodBag.getNotes(), bloodBag.getProcessingDate());
    }

    public static BloodBag toBloodBag(BloodBagEntity bloodBagEntity){
        List<Donation> donations = bloodBagEntity.getDonations().stream()
                .map(DonationEntityMapper::toDonation).toList();
        return new BloodBag(donations, bloodBagEntity.getBloodType(), bloodBagEntity.getBloodComponent(), bloodBagEntity.getBagVolume(), bloodBagEntity.getCollectionDate(), bloodBagEntity.getExpirationDate(), bloodBagEntity.getBagStatus(), bloodBagEntity.getTestResult(), bloodBagEntity.getFreezerNumber(), bloodBagEntity.getBatchCode(), bloodBagEntity.getComplianceStatus(), bloodBagEntity.getNotes(), bloodBagEntity.getProcessingDate());
    }
}
