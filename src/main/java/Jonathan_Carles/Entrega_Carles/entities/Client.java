package Jonathan_Carles.Entrega_Carles.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "CLIENTS")

public class Client {

    public Client(String name, String lastName, String docnumber) {
        this.name = name;
        this.lastName = lastName;
        this.docnumber = docnumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false, length = 75)
    private String name;

    @Column(name="LASTNAME", nullable = false, length = 75)
    private String lastName;

    @Column(name = "DOCNUMBER", nullable = false, length = 11)
    private String docnumber;

    // Relation with Invoice
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Invoice> invoices;
}
