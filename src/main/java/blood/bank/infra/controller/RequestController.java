package blood.bank.infra.controller;

import blood.bank.application.usecases.request.ListRequests;
import blood.bank.application.usecases.request.SendRequestOpinion;
import blood.bank.domain.entities.request.Request;
import blood.bank.infra.models.requests.RequestOpinionRequest;
import blood.bank.infra.models.responses.RequestResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/request")
public class RequestController {

    private final ListRequests listRequests;

    private final SendRequestOpinion sendRequestOpinion;

    public RequestController(ListRequests listRequests, SendRequestOpinion sendRequestOpinion) {
        this.listRequests = listRequests;
        this.sendRequestOpinion = sendRequestOpinion;
    }

    @GetMapping
    List<RequestResponse> listRequests() {
        List<Request> requests = listRequests.getRequests();
        return requests.stream().map(RequestResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/send-request-opinion")
    void sendRequestOpinion(@RequestBody RequestOpinionRequest requestOpinionRequest) {
        sendRequestOpinion.sendRequestOpinion(requestOpinionRequest);
    }
}
