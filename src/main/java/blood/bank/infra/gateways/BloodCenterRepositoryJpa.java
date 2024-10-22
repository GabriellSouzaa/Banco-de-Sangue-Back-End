package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.mappers.BloodCenterEntityMapper;
import blood.bank.infra.persistence.models.BloodCenterEntity;
import blood.bank.infra.persistence.repositories.BloodCenterRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BloodCenterRepositoryJpa implements BloodCenterRepositoryGateway {

    private final BloodCenterRepository repository;

    public BloodCenterRepositoryJpa(BloodCenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BloodCenter> getBloodCenters() {
        List<BloodCenterEntity> bloodCenterEntities = repository.findAll();
        return bloodCenterEntities.stream().map(BloodCenterEntityMapper::toBloodCenter).collect(Collectors.toList());
    }
}
