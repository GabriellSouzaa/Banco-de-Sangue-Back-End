package banco.sangue.infrastructure.persistence.repositories.impl;

import banco.sangue.application.repositories.DonorRepository;
import banco.sangue.infrastructure.persistence.entities.DonorEntity;
import banco.sangue.infrastructure.persistence.repositories.DonorData;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonorDataImpl implements DonorRepository {

    private final DonorData donorData;

    public DonorDataImpl(@Lazy DonorData donorData) {
        this.donorData = donorData;
    }

    @Override
    public List<DonorEntity> findAll() {
        return donorData.findAll();
    }
}
