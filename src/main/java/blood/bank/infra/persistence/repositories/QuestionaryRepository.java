package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.QuestionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionaryRepository extends JpaRepository<QuestionaryEntity, Long> {
}
