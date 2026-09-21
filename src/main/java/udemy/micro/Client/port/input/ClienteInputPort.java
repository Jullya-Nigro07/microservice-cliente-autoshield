package udemy.micro.Client.port.input;

import udemy.micro.Client.domain.cliente.dtos.ClienteRequest;
import udemy.micro.Client.domain.cliente.dtos.ClienteResponse;

public interface ClienteInputPort {
    ClienteResponse registerClient(ClienteRequest clienteRequest);
    ClienteResponse searchClient(String cpf);
}
