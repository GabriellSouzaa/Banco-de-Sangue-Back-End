package blood.bank.application.gateways;

import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.models.requests.GrantDonorBadgeRequest;

import java.util.List;

public interface DonorBadgeRepositoryGateway {
    List<DonorBadge> getDonorBadgesByDonorId(Long donorId);

    void grantDonorBadge(GrantDonorBadgeRequest grantDonorBadgeRequest);
}
