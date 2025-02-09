package blood.bank.application.gateways;

import blood.bank.domain.entities.badge.Badge;
import blood.bank.infra.models.requests.BadgeRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BadgeRepositoryGateway {

    List<Badge> getBadges();

    void createBadge(BadgeRequest badgeRequest, MultipartFile photo);

    void updateBadge(String badgeName, BadgeRequest badgeRequest);

    void deleteBadge(String badgeName);
}
