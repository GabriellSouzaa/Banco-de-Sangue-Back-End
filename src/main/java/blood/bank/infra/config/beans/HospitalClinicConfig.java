package blood.bank.infra.config.beans;

import blood.bank.application.gateways.HospitalClinicRepositoryGateway;
import blood.bank.application.usecases.hospitalClinic.CreateHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.DeleteHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.ListHospitalClinic;
import blood.bank.application.usecases.hospitalClinic.UpdateHospitalClinic;
import blood.bank.infra.gateways.HospitalClinicRepositoryJpa;
import blood.bank.infra.mappers.HospitalClinicEntityMapper;
import blood.bank.infra.persistence.repositories.HospitalClinicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalClinicConfig {

    @Bean
    HospitalClinicEntityMapper hospitalClinicEntityMapper() {
        return new HospitalClinicEntityMapper();
    }

    @Bean
    HospitalClinicRepositoryJpa hospitalClinicRepositoryJpa(HospitalClinicRepository hospitalClinicRepository) {
        return new HospitalClinicRepositoryJpa(hospitalClinicRepository);
    }

    @Bean
    ListHospitalClinic listHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway){
        return new ListHospitalClinic(hospitalClinicRepositoryGateway);
    }

    @Bean
    CreateHospitalClinic createHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway){
        return new CreateHospitalClinic(hospitalClinicRepositoryGateway);
    }

    @Bean
    UpdateHospitalClinic updateHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway){
        return new UpdateHospitalClinic(hospitalClinicRepositoryGateway);
    }

    @Bean
    DeleteHospitalClinic deleteHospitalClinic(HospitalClinicRepositoryGateway hospitalClinicRepositoryGateway){
        return new DeleteHospitalClinic(hospitalClinicRepositoryGateway);
    }
}
