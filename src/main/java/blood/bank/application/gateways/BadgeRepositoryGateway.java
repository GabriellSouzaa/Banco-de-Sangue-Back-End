package blood.bank.application.gateways;

import blood.bank.domain.entities.badge.Badge;

import java.util.List;

public interface BadgeRepositoryGateway {

    List<Badge> getBadges();
}
