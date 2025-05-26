package Jonathan_Carles.Entrega_Carles.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false, length = 75)
    private String name;

    @Column(name = "LASTNAME", nullable = false, length = 75)
    private String lastName;

    @Column(name = "DOCNUMBER", nullable = false, length = 11)
    private String docnumber;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Invoice> invoices;
}

