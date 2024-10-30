package blood.bank.infra.controller;

import blood.bank.application.usecases.scheduling.ListScheduling;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.models.responses.SchedulingResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    private final ListScheduling listScheduling;

    public SchedulingController(ListScheduling listScheduling) {
        this.listScheduling = listScheduling;
    }

    @GetMapping
    List<SchedulingResponse> listScheduling() {
        List<Scheduling> schedulings = listScheduling.getSchedulings();
        return schedulings.stream().map(SchedulingResponse::new).collect(Collectors.toList());
    }
}
