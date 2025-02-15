package blood.bank.infra.mappers;

import blood.bank.domain.entities.address.Address;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.HospitalClinicEntity;


public class HospitalClinicEntityMapper {

    public static HospitalClinicEntity toEntity(HospitalClinic hospitalClinic) {
        AddressEntity addressEntity = AddressEntityMapper.toEntity(hospitalClinic.getAddress());
        return new HospitalClinicEntity(hospitalClinic.getId(), addressEntity, hospitalClinic.getName(), hospitalClinic.getPhone(), hospitalClinic.getEmail());
    }

    public static HospitalClinic toHospitalClinic(HospitalClinicEntity hospitalClinicEntity) {
        Address address = AddressEntityMapper.toAddress(hospitalClinicEntity.getAddress());
        return new HospitalClinic(hospitalClinicEntity.getId(), address, hospitalClinicEntity.getName(), hospitalClinicEntity.getPhone(), hospitalClinicEntity.getEmail());
    }
}
