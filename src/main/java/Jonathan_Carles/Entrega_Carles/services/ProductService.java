package Jonathan_Carles.Entrega_Carles.services;

import Jonathan_Carles.Entrega_Carles.entities.Product;
import Jonathan_Carles.Entrega_Carles.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        Optional<Product> prodDb = productRepository.findById(id);
        if (prodDb.isEmpty()) {
            return Optional.empty();
        }
        product.setId(id);
        return Optional.of(productRepository.save(product));
    }

    public Optional<Product> deleteProduct(Long id) {
        Optional<Product> prodDb = productRepository.findById(id);
        if (prodDb.isEmpty()) {
            return Optional.empty();
        }
        productRepository.delete(prodDb.get());
        return prodDb;
    }
}

