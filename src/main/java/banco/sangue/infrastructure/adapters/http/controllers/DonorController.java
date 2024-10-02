package banco.sangue.infrastructure.adapters.http.controllers;

import banco.sangue.application.usecases.DonorGateway;
import banco.sangue.infrastructure.adapters.http.models.response.DonorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {

    private final DonorGateway donorService;

    @Autowired
    public DonorController(DonorGateway donorService) {
        this.donorService = donorService;
    }

    @GetMapping()
    public ResponseEntity<List<DonorResponse>> getDonors() {
        List<DonorResponse> donors = this.donorService.getDonors();
        return ResponseEntity.ok().body(donors);
    }
}
