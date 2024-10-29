package blood.bank.application.usecases.badge;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.domain.entities.badge.Badge;

import java.util.List;

public class ListBadges {

    private final BadgeRepositoryGateway badgeRepositoryGateway;

    public ListBadges(BadgeRepositoryGateway badgeRepositoryGateway) {
        this.badgeRepositoryGateway = badgeRepositoryGateway;
    }

    public List<Badge> getBadges() {
        return badgeRepositoryGateway.getBadges();
    }
}
