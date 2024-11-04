package blood.bank.application.usecases.badge;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.infra.models.requests.BadgeRequest;

public class UpdateBadge {

    private final BadgeRepositoryGateway badgeRepositoryGateway;

    public UpdateBadge(BadgeRepositoryGateway badgeRepositoryGateway) {
        this.badgeRepositoryGateway = badgeRepositoryGateway;
    }

    public void updateBadge(String badgeName, BadgeRequest badgeRequest){
        badgeRepositoryGateway.updateBadge(badgeName, badgeRequest);
    }
}
