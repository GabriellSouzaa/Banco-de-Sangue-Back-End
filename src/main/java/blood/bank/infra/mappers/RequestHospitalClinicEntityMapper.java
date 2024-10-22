package blood.bank.infra.mappers;

import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.domain.entities.requestHospitalClinic.RequestHospitalClinic;
import blood.bank.infra.persistence.models.HospitalClinicEntity;
import blood.bank.infra.persistence.models.RequestHospitalClinicEntity;

public class RequestHospitalClinicEntityMapper {

    public static RequestHospitalClinicEntity toEntity(RequestHospitalClinic requestHospitalClinic){
        HospitalClinicEntity hospitalClinicEntity = HospitalClinicEntityMapper.toEntity(requestHospitalClinic.getHospitalClinic());
        return new RequestHospitalClinicEntity(hospitalClinicEntity, requestHospitalClinic.getRequestDate(), requestHospitalClinic.getRequestedBloodType(), requestHospitalClinic.getRequestedBloodComponent(), requestHospitalClinic.getNeedByDate(), requestHospitalClinic.getRequestStatus(), requestHospitalClinic.getObservation());
    }

    public static RequestHospitalClinic toRequestHospitalClinic(RequestHospitalClinicEntity requestHospitalClinicEntity){
        HospitalClinic hospitalClinic = HospitalClinicEntityMapper.toHospitalClinic(requestHospitalClinicEntity.getHospitalClinic());
        return new RequestHospitalClinic(hospitalClinic, requestHospitalClinicEntity.getRequestDate(), requestHospitalClinicEntity.getRequestedBloodType(), requestHospitalClinicEntity.getRequestedBloodComponent(), requestHospitalClinicEntity.getRequestedQuantity(), requestHospitalClinicEntity.getNeedByDate(), requestHospitalClinicEntity.getRequestStatus(), requestHospitalClinicEntity.getObservation());
    }
}
