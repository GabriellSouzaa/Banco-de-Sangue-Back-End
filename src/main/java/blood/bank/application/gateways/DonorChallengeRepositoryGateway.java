package blood.bank.application.gateways;

import blood.bank.domain.entities.donorChallenge.DonorChallenge;
import blood.bank.infra.models.requests.GrantDonorChallengeRequest;

import java.util.List;

public interface DonorChallengeRepositoryGateway {

    List<DonorChallenge> getDonorChallengeByDonorFullNameAndEmail(String donorName, String email);

    void grantDonorChallenge(GrantDonorChallengeRequest grantDonorChallengeRequest);
}
