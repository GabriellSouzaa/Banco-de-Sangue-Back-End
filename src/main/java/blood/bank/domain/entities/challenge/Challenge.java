package blood.bank.domain.entities.challenge;

import blood.bank.infra.persistence.models.RewardEntity;

import java.time.LocalDate;

public class Challenge {

    private RewardEntity reward;

    private String challengeName;

    private String description;

    private String criteria;

    private LocalDate startDate;

    private LocalDate endDate;
}
