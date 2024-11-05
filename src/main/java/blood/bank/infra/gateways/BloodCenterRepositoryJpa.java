package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.mappers.BloodCenterEntityMapper;
import blood.bank.infra.models.requests.BloodCenterRequest;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.BloodCenterEntity;
import blood.bank.infra.persistence.repositories.AddressRepository;
import blood.bank.infra.persistence.repositories.BloodCenterRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BloodCenterRepositoryJpa implements BloodCenterRepositoryGateway {

    private final BloodCenterRepository repository;

    private final AddressRepository addressRepository;

    public BloodCenterRepositoryJpa(BloodCenterRepository repository, AddressRepository addressRepository) {
        this.repository = repository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<BloodCenter> getBloodCenters() {
        List<BloodCenterEntity> bloodCenterEntities = repository.findAll();
        return bloodCenterEntities.stream().map(BloodCenterEntityMapper::toBloodCenter).collect(Collectors.toList());
    }

    @Override
    public void createBloodCenter(Long idAddress, BloodCenterRequest bloodCenterRequest) {
        BloodCenterEntity bloodCenterEntity = new BloodCenterEntity();
        AddressEntity addressEntity = this.addressRepository.findById(idAddress).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        bloodCenterEntity.setAddress(addressEntity);
        bloodCenterEntity.setBloodCenterName(bloodCenterRequest.getBloodCenterName());
        bloodCenterEntity.setEmail(bloodCenterRequest.getEmail());
        this.repository.save(bloodCenterEntity);
    }

    @Override
    public void updateBloodCenter(Long id, BloodCenterRequest bloodCenterRequest) {
        BloodCenterEntity bloodCenterEntity = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe Hemocentro com esse id"));
        bloodCenterEntity.setAddress(bloodCenterEntity.getAddress());
        bloodCenterEntity.setBloodCenterName(bloodCenterRequest.getBloodCenterName());
        bloodCenterEntity.setEmail(bloodCenterRequest.getEmail());
        this.repository.save(bloodCenterEntity);
    }

    @Override
    public void deleteBloodCenter(Long id) {
        BloodCenterEntity bloodCenterEntity = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe Hemocentro com esse id"));
        this.repository.delete(bloodCenterEntity);
    }
}
