package blood.bank.infra.models.responses;

import blood.bank.domain.entities.donorBadge.DonorBadge;

public class DonorBadgeResponse {

    private DonorResponse donor;

    private BadgeResponse badge;

    public DonorBadgeResponse(DonorBadge donorBadge){
        this.donor = new DonorResponse(donorBadge.getDonor());
        this.badge = new BadgeResponse(donorBadge.getBadge());
    }

    public DonorResponse getDonor() {
        return donor;
    }

    public void setDonor(DonorResponse donor) {
        this.donor = donor;
    }

    public BadgeResponse getBadge() {
        return badge;
    }

    public void setBadge(BadgeResponse badge) {
        this.badge = badge;
    }
}
