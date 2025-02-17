package blood.bank.infra.mappers;

import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.persistence.models.BloodCenterEntity;

public class BloodCenterEntityMapper {

    public static BloodCenterEntity toEntity(BloodCenter center){
        return new BloodCenterEntity(center.getId(), AddressEntityMapper.toEntity(center.getAddress()), center.getBloodCenterName(), center.getEmail());
    }

    public static BloodCenter toBloodCenter(BloodCenterEntity entity){
        return new BloodCenter(entity.getId(), AddressEntityMapper.toAddress(entity.getAddress()), entity.getBloodCenterName(), entity.getEmail());
    }
}
