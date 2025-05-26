package Jonathan_Carles.Entrega_Carles.repositories;

import Jonathan_Carles.Entrega_Carles.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }

