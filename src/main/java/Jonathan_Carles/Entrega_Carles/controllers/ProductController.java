package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.Product;
import Jonathan_Carles.Entrega_Carles.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> getById(@PathVariable Long id) {
        Optional<Product> prod = productService.getProduct(id);
        if (prod.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prod);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Optional<Product>> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        Optional<Product> updated = productService.updateProduct(id, product);
        if (updated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Product>> delete(@PathVariable Long id) {
        Optional<Product> deleted = productService.deleteProduct(id);
        if (deleted.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}
