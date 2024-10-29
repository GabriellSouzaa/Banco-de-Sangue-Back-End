package blood.bank.infra.controller;

import blood.bank.application.usecases.badge.ListBadges;
import blood.bank.domain.entities.badge.Badge;
import blood.bank.infra.models.responses.BadgeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/badge")
public class BadgeController {

    private final ListBadges listBadges;

    public BadgeController(ListBadges listBadges) {
        this.listBadges = listBadges;
    }

    @GetMapping
    List<BadgeResponse> listBadges(){
        List<Badge> badges = listBadges.getBadges();
        return badges.stream().map(BadgeResponse::new).collect(Collectors.toList());
    }
}
