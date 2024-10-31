package blood.bank.application.gateways;

import blood.bank.domain.entities.donorBadge.DonorBadge;

import java.util.List;

public interface DonorBadgeRepositoryGateway {
    List<DonorBadge> getDonorBadgesByDonorId(Long donorId);
}
