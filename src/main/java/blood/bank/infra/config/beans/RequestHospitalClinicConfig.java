package blood.bank.infra.config.beans;

import blood.bank.application.gateways.RequestHospitalClinicRepositoryGateway;
import blood.bank.application.usecases.requestHospitalClinic.*;
import blood.bank.infra.gateways.RequestHospitalClinicJpa;
import blood.bank.infra.mappers.RequestHospitalClinicEntityMapper;
import blood.bank.infra.persistence.repositories.HospitalClinicRepository;
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
    RequestHospitalClinicJpa requestHospitalClinicJpa(RequestHospitalClinicRepository requestHospitalClinicRepository, RequestHospitalClinicEntityMapper requestHospitalClinicEntityMapper, HospitalClinicRepository hospitalClinicRepository) {
        return new RequestHospitalClinicJpa(requestHospitalClinicRepository, requestHospitalClinicEntityMapper, hospitalClinicRepository);
    }

    @Bean
    ListRequestHospitalClinic listRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway){
        return new ListRequestHospitalClinic(requestHospitalClinicRepositoryGateway);
    }

    @Bean
    CreateRequestHospitalClinic createRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway){
        return new CreateRequestHospitalClinic(requestHospitalClinicRepositoryGateway);
    }

    @Bean
    UpdateRequestHospitalClinic updateRequestHospitalClinic(RequestHospitalClinicRepositoryGateway repositoryGateway) {
        return new UpdateRequestHospitalClinic(repositoryGateway);
    }

    @Bean
    DeleteRequestHospitalClinic deleteRequestHospitalClinic(RequestHospitalClinicRepositoryGateway requestHospitalClinicRepositoryGateway) {
        return new DeleteRequestHospitalClinic(requestHospitalClinicRepositoryGateway);
    }
}
