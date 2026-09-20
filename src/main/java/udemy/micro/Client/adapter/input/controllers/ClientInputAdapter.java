package udemy.micro.Client.adapter.input.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import udemy.micro.Client.domain.cliente.dtos.ClientRequest;
import udemy.micro.Client.domain.cliente.dtos.ClientResponse;
import udemy.micro.Client.port.input.ClientInputPort;

@RestController
@RequestMapping("/clients")
public class ClientInputAdapter {
    private final ClientInputPort clientInputPort;

    public ClientInputAdapter(ClientInputPort clientInputPort) {
        this.clientInputPort = clientInputPort;
    }

    @PostMapping("/register")
    public ClientResponse registerClient(@Valid @RequestBody ClientRequest clientRequest){
        return clientInputPort.registerClient(clientRequest);
    }

    @GetMapping("/search/{cpf}")
    public ClientResponse searchClient(@PathVariable String cpf){
        return clientInputPort.searchClient(cpf);
    }

    @GetMapping
    public String status(){
        return "OK";
    }
}
