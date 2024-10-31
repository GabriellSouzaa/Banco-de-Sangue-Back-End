package blood.bank.infra.persistence.models;

import java.io.Serializable;

public class DonorBadgeId implements Serializable {

    private Long donorId;

    private Long badgeId;

    public DonorBadgeId(){

    }

    public DonorBadgeId(Long donorId, Long badgeId) {
        this.donorId = donorId;
        this.badgeId = badgeId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }
}
