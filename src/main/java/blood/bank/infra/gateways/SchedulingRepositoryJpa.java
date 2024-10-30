package blood.bank.infra.gateways;

import blood.bank.application.gateways.SchedulingRepositoryGateway;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.mappers.SchedulingEntityMapper;
import blood.bank.infra.persistence.models.SchedulingEntity;
import blood.bank.infra.persistence.repositories.SchedulingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulingRepositoryJpa implements SchedulingRepositoryGateway {

    private final SchedulingRepository schedulingRepository;

    public SchedulingRepositoryJpa(SchedulingRepository schedulingRepository, SchedulingEntityMapper schedulingEntityMapper) {
        this.schedulingRepository = schedulingRepository;
    }


    @Override
    public List<Scheduling> getSchedulings() {
        List<SchedulingEntity> schedulings = this.schedulingRepository.findAll();
        return schedulings.stream().map(SchedulingEntityMapper::toScheduling).collect(Collectors.toList());
    }
}
