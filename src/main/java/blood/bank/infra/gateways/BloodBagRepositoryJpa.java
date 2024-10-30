package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.repositories.BloodBagRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BloodBagRepositoryJpa implements BloodBagRepositoryGateway {

    private final BloodBagRepository bloodBagRepository;

    private final BloodBagEntityMapper bloodBagEntityMapper;

    private final JdbcTemplate jdbcTemplate;

    public BloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, BloodBagEntityMapper bloodBagEntityMapper, JdbcTemplate jdbcTemplate) {
        this.bloodBagRepository = bloodBagRepository;
        this.bloodBagEntityMapper = bloodBagEntityMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BloodBag> getBloodBags() {
        List<BloodBagEntity> bloodBags = bloodBagRepository.findAll();
        return bloodBags.stream().map(BloodBagEntityMapper::toBloodBag).collect(Collectors.toList());
    }

    @Override
    public void deleteExpiredBloodBags() {
        String sql = "DELETE FROM bolsa_de_sangue WHERE data_validade < ?";
        jdbcTemplate.update(sql, LocalDate.now());
    }

}
