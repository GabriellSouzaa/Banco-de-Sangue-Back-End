package blood.bank.infra.controller;

import blood.bank.application.usecases.donorBadge.GrantDonorBadge;
import blood.bank.application.usecases.donorBadge.ListDonorBadgesByDonorId;
import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.models.requests.GrantDonorBadgeRequest;
import blood.bank.infra.models.responses.DonorBadgeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donor-badge")
@RestController
public class DonorBadgeController {

    private final ListDonorBadgesByDonorId listDonorBadgesByDonorId;

    private final GrantDonorBadge grantDonorBadge;

    public DonorBadgeController(ListDonorBadgesByDonorId listDonorBadgesByDonorId, GrantDonorBadge grantDonorBadge) {
        this.listDonorBadgesByDonorId = listDonorBadgesByDonorId;
        this.grantDonorBadge = grantDonorBadge;
    }

    @GetMapping("/list-donor-badges/{id}")
    public List<DonorBadgeResponse> getDonorBadgesByDonorId(@PathVariable Long id){
        List<DonorBadge> donorBadges = this.listDonorBadgesByDonorId.getDonorBadgesByDonorId(id);
        return donorBadges.stream().map(DonorBadgeResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/grant-donor-badge")
    public void grantDonorBadge(@RequestBody GrantDonorBadgeRequest grantDonorBadgeRequest){
        this.grantDonorBadge.grantDonorBadge(grantDonorBadgeRequest);
    }
}
