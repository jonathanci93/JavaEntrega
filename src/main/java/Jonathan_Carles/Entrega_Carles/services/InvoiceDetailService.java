package Jonathan_Carles.Entrega_Carles.services;

import Jonathan_Carles.Entrega_Carles.entities.InvoiceDetail;
import Jonathan_Carles.Entrega_Carles.repositories.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;


    public List<InvoiceDetail> getDetails() {
        return invoiceDetailRepository.findAll();
    }


    public Optional<InvoiceDetail> getDetail(Integer id) {
        return invoiceDetailRepository.findById(id);
    }


    public InvoiceDetail saveDetail(InvoiceDetail detail) {
        return invoiceDetailRepository.save(detail);
    }


    public Optional<InvoiceDetail> updateDetail(Integer id, InvoiceDetail detail) {
        Optional<InvoiceDetail> existing = invoiceDetailRepository.findById(id);
        if (existing.isPresent()) {
            detail.setInvoiceDetailId(id);
            return Optional.of(invoiceDetailRepository.save(detail));
        }
        return Optional.empty();
    }


    public Optional<InvoiceDetail> deleteDetail(Integer id) {
        Optional<InvoiceDetail> toDelete = invoiceDetailRepository.findById(id);
        toDelete.ifPresent(invoiceDetailRepository::delete);
        return toDelete;
    }
}
