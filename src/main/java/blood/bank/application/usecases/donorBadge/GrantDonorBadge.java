package blood.bank.application.usecases.donorBadge;

import blood.bank.application.gateways.DonorBadgeRepositoryGateway;
import blood.bank.infra.models.requests.GrantDonorBadgeRequest;

public class GrantDonorBadge {

    private final DonorBadgeRepositoryGateway donorBadgeRepositoryGateway;

    public GrantDonorBadge(DonorBadgeRepositoryGateway donorBadgeRepositoryGateway) {
        this.donorBadgeRepositoryGateway = donorBadgeRepositoryGateway;
    }

    public void grantDonorBadge(GrantDonorBadgeRequest grantDonorBadgeRequest){
        this.donorBadgeRepositoryGateway.grantDonorBadge(grantDonorBadgeRequest);
    }
}
