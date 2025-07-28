package fa.training.entities;

import fa.training.entities.enums.OrderStatus;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(LocalDate orderDate, LocalDate shipDate, String shipAddress, OrderStatus status, Customer customer) {
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.status = status;
        this.customer = customer;
    }

    public Order() {
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
