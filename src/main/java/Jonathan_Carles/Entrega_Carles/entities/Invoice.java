package Jonathan_Carles.Entrega_Carles.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "INVOICE")

public class Invoice {

    public Invoice (Client client, double total) {
        this.client = client;
        this.createdAt = LocalDateTime.now();
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "TOTAL", nullable = false)
    private double total;

}
