package blood.bank.infra.persistence.repositories;


import blood.bank.domain.entities.donor.Donor;
import blood.bank.infra.persistence.models.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DonorRepository extends JpaRepository<DonorEntity, Long> {
    DonorEntity findDonorEntityByPeople_FullNameAndPeople_Email(String fullName, String email);
}
