package blood.bank.infra.persistence.repositories;

import blood.bank.infra.persistence.models.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    List<AnswerEntity> findAnswerEntityByDonor_People_FullNameAndDonor_PeopleEmailAndQuestion_Text(String fullName, String email, String questionText);
}
