package Jonathan_Carles.Entrega_Carles.services;

import Jonathan_Carles.Entrega_Carles.entities.Client;
import Jonathan_Carles.Entrega_Carles.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> updateClient(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isEmpty()) {
            return Optional.empty();
        }
        client.setId(id);
        return Optional.of(clientRepository.save(client));
    }


    public Optional<Client> deleteClient(Long id) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isEmpty()) {
            return Optional.empty();
        }
        clientRepository.delete(clientDb.get());
        return clientDb;
    }
}


