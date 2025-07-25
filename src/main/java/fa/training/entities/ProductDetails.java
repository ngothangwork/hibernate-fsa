package fa.training.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details", schema = "dbo")
public class ProductDetails extends EntityBase {

    @Column(name = "color", length = 50, columnDefinition = "nvarchar(50)")
    private String color;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "size", length = 50, columnDefinition = "nvarchar(50)")
    private String size;

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

}
