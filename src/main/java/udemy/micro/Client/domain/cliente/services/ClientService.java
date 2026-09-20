package udemy.micro.Client.domain.cliente.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import udemy.micro.Client.domain.cliente.dtos.ClientRequest;
import udemy.micro.Client.domain.cliente.dtos.ClientResponse;
import udemy.micro.Client.adapter.output.repository.entity.Client;
import udemy.micro.Client.port.input.ClientInputPort;
import udemy.micro.Client.port.output.ClientOutputPort;

@Service
public class ClientService implements ClientInputPort {
    private final ClientOutputPort clientOutputPort;

    public ClientService(ClientOutputPort clientOutputPort){
        this.clientOutputPort = clientOutputPort;
    }

    @Override
    @Transactional
    public ClientResponse registerClient(ClientRequest clientRequest) {
        clientOutputPort.findClientByCpf(clientRequest.cpf()).ifPresent(client -> {
            throw new RuntimeException("CPF já cadastrado");});

        Client client = new Client(clientRequest.name(), clientRequest.cpf());
        Client clientSave = clientOutputPort.save(client);

        return new ClientResponse(clientSave.getId(), clientSave.getName());
    }

    @Override
    public ClientResponse searchClient(String cpf) {
        Client client = clientOutputPort.findClientByCpf(cpf).orElseThrow(() -> new RuntimeException("Erro"));

        return new ClientResponse(client.getId(), client.getName());
    }
}
