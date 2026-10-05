package udemy.micro.cliente.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udemy.micro.cliente.adapter.output.entity.Cliente;
import udemy.micro.cliente.port.output.ClienteOutputPort;
import java.util.Optional;

public interface ClienteRespository extends ClienteOutputPort, JpaRepository<Cliente, Long>  {
    Optional<Cliente> findClienteByCpf(String cpf);
    Cliente save(Cliente client);
}
