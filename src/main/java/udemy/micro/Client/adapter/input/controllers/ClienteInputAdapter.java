package udemy.micro.Client.adapter.input.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import udemy.micro.Client.domain.cliente.dtos.ClienteRequest;
import udemy.micro.Client.domain.cliente.dtos.ClienteResponse;
import udemy.micro.Client.port.input.ClienteInputPort;

@RestController
@RequestMapping("/clients")
@Slf4j
public class ClienteInputAdapter {
    private final ClienteInputPort clienteInputPort;

    public ClienteInputAdapter(ClienteInputPort clienteInputPort) {
        this.clienteInputPort = clienteInputPort;
    }

    @PostMapping("/register")
    public ClienteResponse registerClient(@Valid @RequestBody ClienteRequest clienteRequest){
        return clienteInputPort.registerClient(clienteRequest);
    }

    @GetMapping("/search/{cpf}")
    public ClienteResponse searchClient(@PathVariable String cpf){
        return clienteInputPort.searchClient(cpf);
    }

    @GetMapping
    public String status(){
        log.info("testando status do micro");
        return "OK";
    }
}
