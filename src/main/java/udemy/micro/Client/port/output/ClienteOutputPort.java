package udemy.micro.Client.port.output;

import udemy.micro.Client.adapter.output.entity.Cliente;
import java.util.Optional;

public interface ClienteOutputPort {
    Optional<Cliente> findClientByCpf(String cpf);
    Cliente save(Cliente client);
}
