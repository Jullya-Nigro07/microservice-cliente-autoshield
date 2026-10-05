package udemy.micro.cliente.port.input;

import udemy.micro.cliente.domain.cliente.dtos.ClienteRequest;
import udemy.micro.cliente.domain.cliente.dtos.ClienteResponse;

public interface ClienteInputPort {
    ClienteResponse registerCliente(ClienteRequest clienteRequest);
    ClienteResponse searchCliente(String cpf);
}
