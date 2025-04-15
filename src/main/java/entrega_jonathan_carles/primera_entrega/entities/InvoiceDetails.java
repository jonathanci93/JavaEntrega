package entrega_jonathan_carles.primera_entrega.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "INVOICE_DETAILS")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Relacion ManyToOne con la factura porque muchos detalles estan asociados a una factura
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    // Relacion ManyToOne con la factura al producto porque muchos detalles estan asociados a un producto
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Products product;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Products products;

}
