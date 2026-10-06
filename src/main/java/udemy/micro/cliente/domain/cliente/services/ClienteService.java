package udemy.micro.cliente.domain.cliente.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import udemy.micro.cliente.adapter.output.entity.Cliente;
import udemy.micro.cliente.domain.cliente.dtos.ClienteRequest;
import udemy.micro.cliente.domain.cliente.dtos.ClienteResponse;
import udemy.micro.cliente.port.input.ClienteInputPort;
import udemy.micro.cliente.port.output.ClienteOutputPort;

@Service
public class ClienteService implements ClienteInputPort {

    private final ClienteOutputPort clienteOutputPort;
    public ClienteService(ClienteOutputPort clienteOutputPort){
        this.clienteOutputPort = clienteOutputPort;
    }

    @Override
    @Transactional
    public ClienteResponse registerCliente(ClienteRequest clienteRequest) {
        clienteOutputPort.findClienteByCpf(clienteRequest.cpf()).ifPresent(cliente -> {
            throw new RuntimeException("CPF já cadastrado");});

        Cliente cliente = new Cliente(clienteRequest.name(), clienteRequest.cpf());
        Cliente clientSave = clienteOutputPort.save(cliente);

        return new ClienteResponse(clientSave.getId(), clientSave.getName(), cliente.getCpf());
    }

    @Override
    public ClienteResponse searchCliente(String cpf) {
        Cliente cliente = clienteOutputPort.findClienteByCpf(cpf).orElseThrow(() -> new RuntimeException("Não encontrado!"));

        return new ClienteResponse(cliente.getId(), cliente.getName(), cliente.getCpf());
    }
}
