package blood.bank.infra.gateways;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.domain.entities.hospitalClinic.HospitalClinic;
import blood.bank.infra.mappers.HospitalClinicEntityMapper;
import blood.bank.infra.models.requests.AddressRequest;
import blood.bank.infra.models.requests.HospitalClinicRequest;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.HospitalClinicEntity;
import blood.bank.infra.persistence.repositories.HospitalClinicRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalClinicRepositoryJpa implements HospitalClinicRepositoryGateway {

    private final HospitalClinicRepository hospitalClinicRepository;


    public HospitalClinicRepositoryJpa(HospitalClinicRepository hospitalClinicRepository) {
        this.hospitalClinicRepository = hospitalClinicRepository;
    }

    @Override
    public List<HospitalClinic> getHospitalClinics() {
        List<HospitalClinicEntity> hospitalClinics = hospitalClinicRepository.findAll();
        return hospitalClinics.stream().map(HospitalClinicEntityMapper::toHospitalClinic).collect(Collectors.toList());
    }

    @Override
    public void createHospitalClinic(HospitalClinicRequest hospitalClinicRequest) {
        HospitalClinicEntity hospitalClinicEntity = new HospitalClinicEntity();
        populateHospitalClinic(hospitalClinicEntity, hospitalClinicRequest);
        hospitalClinicRepository.save(hospitalClinicEntity);
    }

    @Override
    public void updateHospitalClinic(Long id, HospitalClinicRequest hospitalClinicRequest) {
        HospitalClinicEntity hospitalClinicEntity = hospitalClinicRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException("Hospital não encontrado"));
        populateHospitalClinic(hospitalClinicEntity, hospitalClinicRequest);
        hospitalClinicRepository.save(hospitalClinicEntity);
    }

    @Override
    public void deleteHospitalClinic(Long id) {
        HospitalClinicEntity hospitalClinicEntity = hospitalClinicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital não encontrado"));
        hospitalClinicRepository.delete(hospitalClinicEntity);
    }

    private void populateHospitalClinic(HospitalClinicEntity hospitalClinicEntity, HospitalClinicRequest hospitalClinicRequest) {
        hospitalClinicEntity.setAddress(mapToAddressEntity(hospitalClinicRequest.getAddress()));
        hospitalClinicEntity.setName(hospitalClinicRequest.getName());
        hospitalClinicEntity.setPhone(hospitalClinicRequest.getPhone());
        hospitalClinicEntity.setEmail(hospitalClinicRequest.getEmail());
    }

    private AddressEntity mapToAddressEntity(AddressRequest addressRequest) {
        return new AddressEntity(
                addressRequest.getStreet(),
                addressRequest.getNumber(),
                addressRequest.getNeighborhood(),
                addressRequest.getCity(),
                addressRequest.getState(),
                addressRequest.getPostalCode()
        );
    }

}
