package Jonathan_Carles.Entrega_Carles.services;

import Jonathan_Carles.Entrega_Carles.entities.Invoice;
import Jonathan_Carles.Entrega_Carles.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoice(Integer id) {
        return invoiceRepository.findById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
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

