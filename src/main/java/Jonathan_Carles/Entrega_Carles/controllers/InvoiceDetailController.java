package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.InvoiceDetail;
import Jonathan_Carles.Entrega_Carles.services.InvoiceDetailService;
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

@Tag(name = "Detalles de Factura", description = "Operaciones relacionadas con los detalles de las facturas")
@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Operation(summary = "Listar todos los detalles de factura")
    @ApiResponse(responseCode = "200", description = "Detalles de factura devueltos correctamente")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceDetail>> getAll() {
        return ResponseEntity.ok(invoiceDetailService.getDetails());
    }

    @Operation(summary = "Obtener un detalle de factura por ID")
    @ApiResponse(responseCode = "200", description = "Detalle encontrado")
    @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<InvoiceDetail>> getById(@PathVariable Integer id) {
        Optional<InvoiceDetail> det = invoiceDetailService.getDetail(id);
        return det.isPresent() ? ResponseEntity.ok(det) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crear un nuevo detalle de factura")
    @ApiResponse(responseCode = "201", description = "Detalle creado exitosamente")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<InvoiceDetail> create(@RequestBody InvoiceDetail detail) {
        InvoiceDetail saved = invoiceDetailService.saveDetail(detail);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(summary = "Actualizar un detalle de factura existente")
    @ApiResponse(responseCode = "200", description = "Detalle actualizado")
    @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Optional<InvoiceDetail>> update(
            @PathVariable Integer id,
            @RequestBody InvoiceDetail detail
    ) {
        Optional<InvoiceDetail> updated = invoiceDetailService.updateDetail(id, detail);
        return updated.isPresent() ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un detalle de factura por ID")
    @ApiResponse(responseCode = "200", description = "Detalle eliminado")
    @ApiResponse(responseCode = "404", description = "Detalle no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<InvoiceDetail>> delete(@PathVariable Integer id) {
        Optional<InvoiceDetail> deleted = invoiceDetailService.deleteDetail(id);
        return deleted.isPresent() ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }
}

