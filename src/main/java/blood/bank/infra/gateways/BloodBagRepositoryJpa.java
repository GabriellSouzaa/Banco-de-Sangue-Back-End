package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.repositories.BloodBagRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BloodBagRepositoryJpa implements BloodBagRepositoryGateway {

    private final BloodBagRepository bloodBagRepository;

    private final BloodBagEntityMapper bloodBagEntityMapper;

    public BloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, BloodBagEntityMapper bloodBagEntityMapper) {
        this.bloodBagRepository = bloodBagRepository;
        this.bloodBagEntityMapper = bloodBagEntityMapper;
    }

    @Override
    public List<BloodBag> getBloodBags() {
        List<BloodBagEntity> bloodBags = bloodBagRepository.findAll();
        return bloodBags.stream().map(BloodBagEntityMapper::toBloodBag).collect(Collectors.toList());
    }
}
