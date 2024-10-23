package blood.bank.infra.config.beans;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.application.usecases.requestHospitalClinic.ListRequestHospitalClinic;
import blood.bank.application.usecases.requestHospitalClinic.UpdateStatusOfRequestHospitalClinic;
import blood.bank.infra.gateways.RequestHospitalClinicJpa;
import blood.bank.infra.mappers.RequestHospitalClinicEntityMapper;
import blood.bank.infra.persistence.repositories.RequestHospitalClinicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestHospitalClinicConfig {

    @Bean
    RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper() {
        return new RequestHospitalClinicEntityMapper();
    }

    @Bean
    UpdateStatusOfRequestHospitalClinic updateStatusOfRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        return new UpdateStatusOfRequestHospitalClinic(requestHospitalClinicRepositoryGateway);
    }

    @Bean
    RequestHospitalClinicJpa requestHospitalClinicJpa(RequestHospitalClinicRepository requestHospitalClinicRepository, RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper) {
        return new RequestHospitalClinicJpa(requestHospitalClinicRepository, requestHospitalClinicEntityMapper);
    }

    @Bean
    ListRequestHospitalClinic listRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway){
        return new ListRequestHospitalClinic(requestHospitalClinicRepositoryGateway);
    }
}
