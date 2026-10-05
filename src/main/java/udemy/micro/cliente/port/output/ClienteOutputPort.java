package udemy.micro.cliente.port.output;

import udemy.micro.cliente.adapter.output.entity.Cliente;
import java.util.Optional;

public interface ClienteOutputPort {
    Optional<Cliente> findClientByCpf(String cpf);
    Cliente save(Cliente client);
}
