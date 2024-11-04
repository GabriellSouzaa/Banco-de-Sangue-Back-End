package blood.bank.infra.controller;

import blood.bank.application.usecases.badge.CreateBadge;
import blood.bank.application.usecases.badge.DeleteBadge;
import blood.bank.application.usecases.badge.ListBadges;
import blood.bank.application.usecases.badge.UpdateBadge;
import blood.bank.domain.entities.badge.Badge;
import blood.bank.infra.models.requests.BadgeRequest;
import blood.bank.infra.models.responses.BadgeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/badge")
public class BadgeController {

    private final ListBadges listBadges;

    private final CreateBadge createBadge;

    private final UpdateBadge updateBadge;

    private final DeleteBadge deleteBadge;

    public BadgeController(ListBadges listBadges, CreateBadge createBadge, UpdateBadge updateBadge, DeleteBadge deleteBadge) {
        this.listBadges = listBadges;
        this.createBadge = createBadge;
        this.updateBadge = updateBadge;
        this.deleteBadge = deleteBadge;
    }

    @GetMapping
    List<BadgeResponse> listBadges(){
        List<Badge> badges = listBadges.getBadges();
        return badges.stream().map(BadgeResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    void createBadge(@RequestBody BadgeRequest badgeRequest){
        createBadge.createBadge(badgeRequest);
    }

    @PutMapping
    void updateBadge(@RequestParam String badgeName, @RequestBody BadgeRequest badgeRequest){
        updateBadge.updateBadge(badgeName, badgeRequest);
    }

    @DeleteMapping
    void deleteBadge(@RequestParam String badgeName){
        deleteBadge.deleteBadge(badgeName);
    }
}
