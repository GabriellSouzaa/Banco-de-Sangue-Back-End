package blood.bank.application.usecases.badge;

import blood.bank.application.gateways.BadgeRepositoryGateway;

public class DeleteBadge {

    private final BadgeRepositoryGateway badgeRepositoryGateway;

    public DeleteBadge(BadgeRepositoryGateway badgeRepositoryGateway) {
        this.badgeRepositoryGateway = badgeRepositoryGateway;
    }

    public void deleteBadge(String badgaName){
        badgeRepositoryGateway.deleteBadge(badgaName);
    }
}
