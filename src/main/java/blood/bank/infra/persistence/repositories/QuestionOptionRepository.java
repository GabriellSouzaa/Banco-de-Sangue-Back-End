package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.QuestionOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionOptionRepository extends JpaRepository<QuestionOptionEntity, Long> {

    List<QuestionOptionEntity> findAllByQuestion_Text(String questionName);
}
