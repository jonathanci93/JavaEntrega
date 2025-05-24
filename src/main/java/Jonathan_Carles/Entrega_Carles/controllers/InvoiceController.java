package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.Invoice;
import Jonathan_Carles.Entrega_Carles.services.InvoiceService;
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

@Tag(name = "Facturas", description = "Operaciones relacionadas con las facturas")
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Operation(summary = "Obtener todas las facturas", description = "Devuelve todas las facturas registradas")
    @ApiResponse(responseCode = "200", description = "Facturas obtenidas correctamente")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoice>> getAll() {
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

    @Operation(summary = "Obtener factura por ID", description = "Devuelve una factura específica por su ID")
    @ApiResponse(responseCode = "200", description = "Factura encontrada")
    @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Invoice>> getById(@PathVariable Integer id) {
        Optional<Invoice> invoice = invoiceService.getInvoice(id);
        return invoice.isPresent() ? ResponseEntity.ok(invoice) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear una nueva factura", description = "Crea una factura nueva en el sistema")
    @ApiResponse(responseCode = "201", description = "Factura creada correctamente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) throws Exception {
        Invoice saved = invoiceService.saveInvoice(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(summary = "Actualizar una factura", description = "Modifica una factura existente")
    @ApiResponse(responseCode = "200", description = "Factura actualizada correctamente")
    @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Invoice>> update(@PathVariable Integer id, @RequestBody Invoice invoice) {
        Optional<Invoice> updated = invoiceService.updateInvoice(id, invoice);
        return updated.isPresent() ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una factura", description = "Elimina una factura del sistema por su ID")
    @ApiResponse(responseCode = "200", description = "Factura eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Invoice>> delete(@PathVariable Integer id) {
        Optional<Invoice> deleted = invoiceService.deleteInvoice(id);
        return deleted.isPresent() ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }
}
