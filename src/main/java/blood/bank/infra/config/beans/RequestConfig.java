package blood.bank.infra.config.beans;

import blood.bank.application.gateways.RequestRepositoryGateway;
import blood.bank.application.usecases.request.ListRequests;
import blood.bank.infra.gateways.RequestRepositoryJpa;
import blood.bank.infra.mappers.RequestEntityMapper;
import blood.bank.infra.persistence.repositories.RequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestConfig {

    @Bean
    RequestEntityMapper requestEntityMapper() {
        return new RequestEntityMapper();
    }

    @Bean
    RequestRepositoryJpa requestRepositoryJpa(RequestRepository requestRepository, RequestEntityMapper requestEntityMapper) {
        return new RequestRepositoryJpa(requestRepository, requestEntityMapper);
    }

    @Bean
    ListRequests listRequests(RequestRepositoryGateway requestRepositoryGateway) {
        return new ListRequests(requestRepositoryGateway);
    }
}
