package entrega_jonathan_carles.primera_entrega.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRICE", nullable = false)
    private double price;

    //@ManyToMany
    //@JoinTable(
    //        name = "INVOICE_DETAILS",
    //        joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"),
    //        inverseJoinColumns = @JoinColumn(name = "INVOICE_ID", referencedColumnName = "ID")
    //)
    //private List<InvoiceDetails> invoiceDetails;
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InvoiceDetails> invoiceDetails;
}

