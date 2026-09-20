package udemy.micro.Client.port.input;

import udemy.micro.Client.domain.cliente.dtos.ClientRequest;
import udemy.micro.Client.domain.cliente.dtos.ClientResponse;

public interface ClientInputPort {
    ClientResponse registerClient(ClientRequest clientRequest);
    ClientResponse searchClient(String cpf);
}
