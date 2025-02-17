package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodCenterRepositoryGateway;
import blood.bank.domain.entities.bloodCenter.BloodCenter;
import blood.bank.infra.mappers.BloodCenterEntityMapper;
import blood.bank.infra.models.requests.BloodCenterRequest;
import blood.bank.infra.persistence.models.AddressEntity;
import blood.bank.infra.persistence.models.BloodCenterEntity;
import blood.bank.infra.persistence.repositories.BloodCenterRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class BloodCenterRepositoryJpa implements BloodCenterRepositoryGateway {

    private final BloodCenterRepository repository;


    private final JdbcTemplate jdbcTemplate;

    public BloodCenterRepositoryJpa(BloodCenterRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BloodCenter> getBloodCenters() {
        List<BloodCenterEntity> bloodCenterEntities = repository.findAll();
        return bloodCenterEntities.stream().map(BloodCenterEntityMapper::toBloodCenter).collect(Collectors.toList());
    }

    @Override
    public void createBloodCenter(BloodCenterRequest bloodCenterRequest) {
        BloodCenterEntity bloodCenterEntity = new BloodCenterEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(bloodCenterRequest.getAddress().getStreet());
        addressEntity.setNumber(bloodCenterRequest.getAddress().getNumber());
        addressEntity.setNeighborhood(bloodCenterRequest.getAddress().getNeighborhood());
        addressEntity.setCity(bloodCenterRequest.getAddress().getCity());
        addressEntity.setState(bloodCenterRequest.getAddress().getState());
        addressEntity.setPostalCode(bloodCenterRequest.getAddress().getPostalCode());
        bloodCenterEntity.setAddress(addressEntity);
        bloodCenterEntity.setBloodCenterName(bloodCenterRequest.getBloodCenterName());
        bloodCenterEntity.setEmail(bloodCenterRequest.getEmail());
        this.repository.save(bloodCenterEntity);
    }

    @Override
    public void updateBloodCenter(Long id, BloodCenterRequest bloodCenterRequest) {
        BloodCenterEntity bloodCenterEntity = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe Hemocentro com esse id"));
        AddressEntity addressEntity = bloodCenterEntity.getAddress();
        addressEntity.setStreet(bloodCenterRequest.getAddress().getStreet());
        addressEntity.setNumber(bloodCenterRequest.getAddress().getNumber());
        addressEntity.setNeighborhood(bloodCenterRequest.getAddress().getNeighborhood());
        addressEntity.setCity(bloodCenterRequest.getAddress().getCity());
        addressEntity.setState(bloodCenterRequest.getAddress().getState());
        addressEntity.setPostalCode(bloodCenterRequest.getAddress().getPostalCode());
        bloodCenterEntity.setAddress(bloodCenterEntity.getAddress());
        bloodCenterEntity.setBloodCenterName(bloodCenterRequest.getBloodCenterName());
        bloodCenterEntity.setEmail(bloodCenterRequest.getEmail());
        this.repository.save(bloodCenterEntity);
    }

    @Override
    public void deleteBloodCenter(Long id) {
        String sql = "DELETE FROM hemocentro WHERE id_hemocentro = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
    }
}
