package Jonathan_Carles.Entrega_Carles.repositories;

import Jonathan_Carles.Entrega_Carles.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
