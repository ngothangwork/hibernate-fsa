package fa.training.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details", schema = "dbo")
public class ProductDetails{

    @Id
    @Column(name = "product_id")
    private Long id;

    @Column(name = "color", length = 50, columnDefinition = "nvarchar(50)")
    private String color;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "size", length = 50, columnDefinition = "nvarchar(50)")
    private String size;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

    public ProductDetails(String color, Double weight, String size, Product product) {
        this.color = color;
        this.weight = weight;
        this.size = size;
        this.product = product;
    }


    public ProductDetails() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
