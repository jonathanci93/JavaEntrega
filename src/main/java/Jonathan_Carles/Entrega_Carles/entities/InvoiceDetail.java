package Jonathan_Carles.Entrega_Carles.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "INVOICE_DETAILS")

public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceDetailId;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "PRICE", nullable = false)
    private double price;
}
