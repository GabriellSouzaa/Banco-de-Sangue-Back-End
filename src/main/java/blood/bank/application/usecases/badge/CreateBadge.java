package blood.bank.application.usecases.badge;

import blood.bank.application.gateways.BadgeRepositoryGateway;
import blood.bank.infra.gateways.BadgeRepositoryJpa;
import blood.bank.infra.models.requests.BadgeRequest;
import org.springframework.web.bind.annotation.RequestBody;

public class CreateBadge {

    private final BadgeRepositoryGateway badgeRepositoryGateway;

    public CreateBadge(BadgeRepositoryGateway badgeRepositoryGateway) {
        this.badgeRepositoryGateway = badgeRepositoryGateway;
    }

    public void createBadge(@RequestBody BadgeRequest badgeRequest){
        badgeRepositoryGateway.createBadge(badgeRequest);
    }
}
