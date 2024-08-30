package banco.sangue.infrastructure.persistence.repositories;

import banco.sangue.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserData extends JpaRepository<UserEntity, Long> {

    UserDetails findByLogin(String login);
}
