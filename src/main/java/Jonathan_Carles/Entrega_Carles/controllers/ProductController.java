package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.Product;
import Jonathan_Carles.Entrega_Carles.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Productos", description = "Operaciones relacionadas con productos")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(
            summary = "Listar todos los productos",
            description = "Devuelve todos los productos registrados en el sistema"
    )
    @ApiResponse(responseCode = "200", description = "Lista devuelta correctamente")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @Operation(
            summary = "Buscar producto por ID",
            description = "Devuelve un producto si existe, o 404 si no se encuentra"
    )
    @ApiResponse(responseCode = "200", description = "Producto encontrado")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> getById(@PathVariable Long id) {
        Optional<Product> prod = productService.getProduct(id);
        if (prod.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prod);
    }

    @Operation(
            summary = "Crear un nuevo producto",
            description = "Agrega un producto nuevo al sistema"
    )
    @ApiResponse(responseCode = "201", description = "Producto creado correctamente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(
            summary = "Actualizar un producto existente",
            description = "Modifica un producto según su ID"
    )
    @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> updated = productService.updateProduct(id, product);
        if (updated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @Operation(
            summary = "Eliminar un producto",
            description = "Elimina un producto si existe"
    )
    @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Product>> delete(@PathVariable Long id) {
        Optional<Product> deleted = productService.deleteProduct(id);
        if (deleted.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}
