package blood.bank.application.usecases.donorBadge;

import blood.bank.application.gateways.DonorBadgeRepositoryGateway;
import blood.bank.domain.entities.donorBadge.DonorBadge;

import java.util.List;

public class ListDonorBadgesByDonorId {

    private final DonorBadgeRepositoryGateway donorBadgeRepositoryGateway;

    public ListDonorBadgesByDonorId(DonorBadgeRepositoryGateway donorBadgeRepositoryGateway) {
        this.donorBadgeRepositoryGateway = donorBadgeRepositoryGateway;
    }

    public List<DonorBadge> getDonorBadgesByDonorId(Long donorId) {
        return donorBadgeRepositoryGateway.getDonorBadgesByDonorId(donorId);
    }
}
