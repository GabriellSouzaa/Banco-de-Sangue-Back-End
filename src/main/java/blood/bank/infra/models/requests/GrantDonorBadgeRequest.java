package blood.bank.infra.models.requests;

public class GrantDonorBadgeRequest {

    private Long donorId;

    private String badgeName;

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
}
