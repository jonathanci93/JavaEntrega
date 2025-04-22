package Jonathan_Carles.Entrega_Carles.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DESCRIPTION", nullable = false, length = 150)
    private String description;

    @Column(name = "CODE", nullable = false, length = 50)
    private String code;

    @Column(name = "STOCK", nullable = false)
    private int stock;

    @Column(name = "PRICE", nullable = false)
    private double price;

    //Relation with InvoiceDetail
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<InvoiceDetail> invoiceDetails;

}
