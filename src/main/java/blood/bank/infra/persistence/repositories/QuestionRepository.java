package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    List<QuestionEntity> findAllByQuestionary_Name(String questionaryName);

}
