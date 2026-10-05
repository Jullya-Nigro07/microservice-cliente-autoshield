package udemy.micro.cliente.adapter.input.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import udemy.micro.cliente.domain.cliente.dtos.ClienteRequest;
import udemy.micro.cliente.domain.cliente.dtos.ClienteResponse;
import udemy.micro.cliente.port.input.ClienteInputPort;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteInputAdapter {
    private final ClienteInputPort clienteInputPort;

    public ClienteInputAdapter(ClienteInputPort clienteInputPort) {
        this.clienteInputPort = clienteInputPort;
    }

    @PostMapping("/register")
    public ClienteResponse registerCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        return clienteInputPort.registerCliente(clienteRequest);
    }

    @GetMapping("/search/{cpf}")
    public ClienteResponse searchCliente(@PathVariable String cpf){
        return clienteInputPort.searchCliente(cpf);
    }

    @GetMapping
    public String status(){
        log.info("testando status do micro");
        return "OK";
    }
}