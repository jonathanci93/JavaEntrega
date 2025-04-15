package entrega_jonathan_carles.primera_entrega.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Entity
@Table(name = "CLIENTS")
public class Client {
    // id int primary key auto_increment not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DNI", nullable = false, unique = true)
    private long dni;

    // Relation with Invoice
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices;


    @ManyToMany(mappedBy = "clients")
    private List<Products> products;
}
