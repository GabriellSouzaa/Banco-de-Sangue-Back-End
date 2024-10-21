package blood.bank.infra.gateways;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.mappers.HospitalClinicEntityMapper;
import blood.bank.infra.persistence.models.HospitalClinicEntity;
import blood.bank.infra.persistence.repositories.HospitalClinicRepository;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalClinicRepositoryJpa implements HospitalClinicRepositoryGateway {

    private final HospitalClinicRepository hospitalClinicRepository;

    private final HospitalClinicEntityMapper hospitalClinicEntityMapper;


    public HospitalClinicRepositoryJpa(HospitalClinicRepository hospitalClinicRepository, HospitalClinicEntityMapper hospitalClinicEntityMapper) {
        this.hospitalClinicRepository = hospitalClinicRepository;
        this.hospitalClinicEntityMapper = hospitalClinicEntityMapper;
    }

    @Override
    public List<HospitalClinic> getHospitalClinics() {
        List<HospitalClinicEntity> hospitalClinics = hospitalClinicRepository.findAll();
        return hospitalClinics.stream().map(HospitalClinicEntityMapper::toHospitalClinic).collect(Collectors.toList());
    }
}
