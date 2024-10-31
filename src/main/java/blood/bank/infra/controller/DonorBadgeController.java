package blood.bank.infra.controller;

import blood.bank.application.usecases.donorBadge.ListDonorBadgesByDonorId;
import blood.bank.domain.entities.donorBadge.DonorBadge;
import blood.bank.infra.models.responses.DonorBadgeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/donor-badge")
@RestController
public class DonorBadgeController {

    private final ListDonorBadgesByDonorId listDonorBadgesByDonorId;

    public DonorBadgeController(ListDonorBadgesByDonorId listDonorBadgesByDonorId){
        this.listDonorBadgesByDonorId = listDonorBadgesByDonorId;
    }

    @GetMapping("/list-donor-badges/{id}")
    public List<DonorBadgeResponse> getDonorBadgesByDonorId(@PathVariable Long id){
        List<DonorBadge> donorBadges = this.listDonorBadgesByDonorId.getDonorBadgesByDonorId(id);
        return donorBadges.stream().map(DonorBadgeResponse::new).collect(Collectors.toList());
    }
}
