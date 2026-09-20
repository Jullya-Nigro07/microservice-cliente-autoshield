package udemy.micro.Client.port.output;

import udemy.micro.Client.adapter.output.repository.entity.Client;

import java.util.Optional;

public interface ClientOutputPort {
    Optional<Client> findClientByCpf(String cpf);
    Client save(Client client);
}
