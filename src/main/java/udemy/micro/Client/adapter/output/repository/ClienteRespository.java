package udemy.micro.Client.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udemy.micro.Client.adapter.output.entity.Cliente;
import udemy.micro.Client.port.output.ClienteOutputPort;
import java.util.Optional;

public interface ClienteRespository extends ClienteOutputPort, JpaRepository<Cliente, Long>  {
    Optional<Cliente> findClientByCpf(String cpf);
    Cliente save(Cliente client);
}
