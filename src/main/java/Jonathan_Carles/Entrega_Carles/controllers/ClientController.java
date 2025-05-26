package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.Client;
import Jonathan_Carles.Entrega_Carles.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Clientes", description = "Operaciones relacionadas con los clientes")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de todos los clientes")
    @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida correctamente")
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @Operation(summary = "Obtener cliente por ID", description = "Devuelve un cliente según su ID")
    @ApiResponse(responseCode = "200", description = "Cliente encontrado")
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClient(id);
        return client.isPresent() ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear nuevo cliente", description = "Crea un nuevo cliente con los datos proporcionados")
    @ApiResponse(responseCode = "201", description = "Cliente creado correctamente")
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client saved = clientService.saveClient(client);
        return ResponseEntity.status(201).body(saved);
    }

    @Operation(summary = "Actualizar cliente", description = "Actualiza un cliente existente")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Client>> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client> updated = clientService.updateClient(id, client);
        return updated.isPresent() ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente por su ID")
    @ApiResponse(responseCode = "200", description = "Cliente eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Client>> deleteClient(@PathVariable Long id) {
        Optional<Client> deleted = clientService.deleteClient(id);
        return deleted.isPresent() ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }
}
