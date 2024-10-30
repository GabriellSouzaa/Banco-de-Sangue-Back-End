package blood.bank.infra.mappers;

import blood.bank.domain.entities.donor.Donor;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.SchedulingEntity;

public class SchedulingEntityMapper {

    public static SchedulingEntity toEntity(Scheduling scheduling){
        DonorEntity donorEntity = DonorMapper.toEntity(scheduling.getDonor());
        return new SchedulingEntity(donorEntity, scheduling.getDateTimeSchedule(), scheduling.getStatus(), scheduling.getObservations(), scheduling.isCanceled());
    }

    public static Scheduling toScheduling(SchedulingEntity schedulingEntity){
        Donor donor = DonorMapper.toDonor(schedulingEntity.getDonor());
        return new Scheduling(donor, schedulingEntity.getDateTimeSchedule(), schedulingEntity.getStatus(), schedulingEntity.getObservations(), schedulingEntity.isCanceled());
    }
}
