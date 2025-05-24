package Jonathan_Carles.Entrega_Carles.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import Jonathan_Carles.Entrega_Carles.entities.Invoice;
import Jonathan_Carles.Entrega_Carles.entities.Product;
import Jonathan_Carles.Entrega_Carles.entities.InvoiceDetail;
import Jonathan_Carles.Entrega_Carles.repositories.ClientRepository;
import Jonathan_Carles.Entrega_Carles.repositories.InvoiceRepository;
import Jonathan_Carles.Entrega_Carles.repositories.ProductRepository;
import Jonathan_Carles.Entrega_Carles.repositories.InvoiceDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public Invoice saveInvoice(Invoice invoice) throws Exception {
        if (!clientRepository.existsById(invoice.getClient().getId())) {
            throw new Exception("Cliente no encontrado con ID: " + invoice.getClient().getId());
        }

        invoice.setCreatedAt(new Date());

        final int[] totalProductos = {0};

        invoice.getInvoiceDetails().forEach(detail -> {
            Long productId = detail.getProduct().getId();
            int cantidadSolicitada = detail.getAmount();

            Product producto = productRepository.findById(productId).orElseThrow(() ->
                    new RuntimeException("Producto no encontrado con ID: " + productId)
            );

            if (cantidadSolicitada > producto.getStock()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + producto.getDescription());
            }

            producto.setStock(producto.getStock() - cantidadSolicitada);
            productRepository.save(producto);

            detail.setPrice(producto.getPrice());
            detail.setInvoice(invoice);

            totalProductos[0] += cantidadSolicitada;
        });

        double total = invoice.getInvoiceDetails().stream()
                .mapToDouble(d -> d.getPrice() * d.getAmount())
                .sum();
        invoice.setTotal(total);

        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoice(Integer id) {
        return invoiceRepository.findById(id);
    }

    public Optional<Invoice> updateInvoice(Integer id, Invoice invoice) {
        Optional<Invoice> invDb = invoiceRepository.findById(id);
        if (invDb.isEmpty()) {
            return Optional.empty();
        }
        invoice.setId(id);
        return Optional.of(invoiceRepository.save(invoice));
    }

    public Optional<Invoice> deleteInvoice(Integer id) {
        Optional<Invoice> invDb = invoiceRepository.findById(id);
        if (invDb.isEmpty()) {
            return Optional.empty();
        }
        invoiceRepository.delete(invDb.get());
        return invDb;
    }
}
