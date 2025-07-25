package fa.training.dtos;

import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private LocalDateTime shipDate;
    private String shipAddress;

    public OrderDTO() {
    }

    public OrderDTO(Long id, LocalDateTime orderDate, LocalDateTime shipDate, String shipAddress) {
        this.id = id;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDateTime shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
}
