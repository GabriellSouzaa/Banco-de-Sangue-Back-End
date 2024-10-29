package blood.bank.infra.controller;

import blood.bank.application.usecases.request.ListRequests;
import blood.bank.domain.entities.request.Request;
import blood.bank.infra.models.responses.RequestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/request")
public class RequestController {

    private final ListRequests listRequests;

    public RequestController(ListRequests listRequests) {
        this.listRequests = listRequests;
    }

    @GetMapping
    List<RequestResponse> listRequests() {
        List<Request> requests = listRequests.getRequests();
        return requests.stream().map(RequestResponse::new).collect(Collectors.toList());
    }
}
