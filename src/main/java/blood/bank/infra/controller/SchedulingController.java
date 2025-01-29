package blood.bank.infra.controller;

import blood.bank.application.usecases.scheduling.*;
import blood.bank.domain.entities.scheduling.Scheduling;
import blood.bank.infra.models.requests.SchedulingRequest;
import blood.bank.infra.models.responses.SchedulingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    private final ListScheduling listScheduling;

    private final GenerateReportSchedulingMonth generateReportSchedulingMonth;

    private final GenerateReportSchedulingCanceled generateReportSchedulingCanceled;

    private final DeleteSchedulingById deleteSchedulingById;

    private final CreateScheduling createScheduling;

    private final UpdateScheduling updateScheduling;

    private final ListDonorScheduling listDonorScheduling;

    public SchedulingController(ListScheduling listScheduling, GenerateReportSchedulingMonth generateReportSchedulingMonth, GenerateReportSchedulingCanceled generateReportSchedulingCanceled, DeleteSchedulingById deleteSchedulingById, CreateScheduling createScheduling, UpdateScheduling updateScheduling, ListDonorScheduling listDonorScheduling) {
        this.listScheduling = listScheduling;
        this.generateReportSchedulingMonth = generateReportSchedulingMonth;
        this.generateReportSchedulingCanceled = generateReportSchedulingCanceled;
        this.deleteSchedulingById = deleteSchedulingById;
        this.createScheduling = createScheduling;
        this.updateScheduling = updateScheduling;
        this.listDonorScheduling = listDonorScheduling;
    }

    @GetMapping
    List<SchedulingResponse> listScheduling() {
        List<Scheduling> schedulings = listScheduling.getSchedulings();
        return schedulings.stream().map(SchedulingResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/report-schedulings")
    ResponseEntity<byte[]> generateReportSchedulings() {
        return this.generateReportSchedulingMonth.generateReportSchedulingMonth();
    }

    @GetMapping("/report-schedulings-canceled")
    ResponseEntity<byte[]> generateReportSchedulingsCanceled() {
        return this.generateReportSchedulingCanceled.generateReportSchedulingCanceled();
    }

    @PostMapping("/create/{idDonor}")
    public void create(Long idDonor, @RequestBody SchedulingRequest schedulingRequest) {
        this.createScheduling.createScheduling(idDonor, schedulingRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody SchedulingRequest schedulingRequest) {
        this.updateScheduling.updateScheduling(id, schedulingRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.deleteSchedulingById.deleteById(id);
    }

    @GetMapping("/donor/{idDonor}")
    List<SchedulingResponse> listDonorScheduling(@PathVariable Long idDonor) {
        List<Scheduling> schedulings = listDonorScheduling.getDonorSchedulings(idDonor);
        return schedulings.stream().map(SchedulingResponse::new).collect(Collectors.toList());
    }

}
