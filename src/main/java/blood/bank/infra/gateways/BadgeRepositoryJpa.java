package blood.bank.infra.gateways;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.domain.entities.badge.Badge;
import blood.bank.infra.mappers.BadgeEntityMapper;
import blood.bank.infra.models.requests.BadgeRequest;
import blood.bank.infra.persistence.models.BadgeEntity;
import blood.bank.infra.persistence.repositories.BadgeRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class BadgeRepositoryJpa implements BadgeRepositoryGateway {

    private final BadgeRepository badgeRepository;

    private final BadgeEntityMapper badgeEntityMapper;

    public BadgeRepositoryJpa(BadgeRepository badgeRepository, BadgeEntityMapper badgeEntityMapper) {
        this.badgeRepository = badgeRepository;
        this.badgeEntityMapper = badgeEntityMapper;
    }

    @Override
    public List<Badge> getBadges() {
        List<BadgeEntity> badgeEntities = badgeRepository.findAll();
        return badgeEntities.stream().map(BadgeEntityMapper::toBadge).collect(Collectors.toList());
    }

    @Override
    public void createBadge(BadgeRequest badgeRequest) {
        BadgeEntity badgeEntity = new BadgeEntity();

        badgeEntity.setBadgeName(badgeRequest.getBadgeName());
        badgeEntity.setImage(badgeRequest.getImage());
        badgeEntity.setNecessaryPoints(badgeRequest.getNecessaryPoints());
        badgeEntity.setDateOfAchievement(badgeRequest.getDateOfAchievement());

        this.badgeRepository.save(badgeEntity);
    }

    @Override
    public void updateBadge(String badgeName, BadgeRequest badgeRequest) {
        BadgeEntity badgeEntity = badgeRepository.findBadgeEntityByBadgeName(badgeName);

        badgeEntity.setBadgeName(badgeRequest.getBadgeName());
        badgeEntity.setImage(badgeRequest.getImage());
        badgeEntity.setNecessaryPoints(badgeRequest.getNecessaryPoints());
        badgeEntity.setDateOfAchievement(badgeRequest.getDateOfAchievement());

        this.badgeRepository.save(badgeEntity);
    }

    @Override
    public void deleteBadge(String badgeName) {
        BadgeEntity badgeEntity = badgeRepository.findBadgeEntityByBadgeName(badgeName);

        this.badgeRepository.delete(badgeEntity);
    }
}
