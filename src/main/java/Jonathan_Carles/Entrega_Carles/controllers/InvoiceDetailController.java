package Jonathan_Carles.Entrega_Carles.controllers;

import Jonathan_Carles.Entrega_Carles.entities.InvoiceDetail;
import Jonathan_Carles.Entrega_Carles.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceDetail>> getAll() {
        return ResponseEntity.ok(invoiceDetailService.getDetails());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<InvoiceDetail>> getById(@PathVariable Integer id) {
        Optional<InvoiceDetail> det = invoiceDetailService.getDetail(id);
        if (det.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(det);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<InvoiceDetail> create(@RequestBody InvoiceDetail detail) {
        InvoiceDetail saved = invoiceDetailService.saveDetail(detail);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

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
        if (updated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<InvoiceDetail>> delete(@PathVariable Integer id) {
        Optional<InvoiceDetail> deleted = invoiceDetailService.deleteDetail(id);
        if (deleted.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }
}

