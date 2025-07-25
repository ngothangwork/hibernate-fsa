package fa.training.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders", schema = "dbo")
public class Order extends EntityBase {

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "ship_date")
    private LocalDate shipDate;

    @Column(name = "ship_address", length = 200, columnDefinition = "nvarchar(200)")
    private String shipAddress;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
