package udemy.micro.Client.domain.cliente.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import udemy.micro.Client.adapter.output.entity.Cliente;
import udemy.micro.Client.domain.cliente.dtos.ClienteRequest;
import udemy.micro.Client.domain.cliente.dtos.ClienteResponse;
import udemy.micro.Client.port.input.ClienteInputPort;
import udemy.micro.Client.port.output.ClienteOutputPort;

@Service
public class ClienteService implements ClienteInputPort {

    private final ClienteOutputPort clienteOutputPort;
    public ClienteService(ClienteOutputPort clienteOutputPort){
        this.clienteOutputPort = clienteOutputPort;
    }

    @Override
    @Transactional
    public ClienteResponse registerClient(ClienteRequest clienteRequest) {
        clienteOutputPort.findClientByCpf(clienteRequest.cpf()).ifPresent(cliente -> {
            throw new RuntimeException("CPF já cadastrado");});

        Cliente cliente = new Cliente(clienteRequest.name(), clienteRequest.cpf());
        Cliente clientSave = clienteOutputPort.save(cliente);

        return new ClienteResponse(clientSave.getId(), clientSave.getName());
    }

    @Override
    public ClienteResponse searchClient(String cpf) {
        Cliente cliente = clienteOutputPort.findClientByCpf(cpf).orElseThrow(() -> new RuntimeException("Erro"));

        return new ClienteResponse(cliente.getId(), cliente.getName());
    }
}
