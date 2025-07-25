package fa.training.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers", schema = "dbo")
public class Supplier extends EntityBase {

    @Column(name = "name", nullable = false, length = 100, columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "address", length = 200, columnDefinition = "nvarchar(200)")
    private String address;

    // Constructors, Getters & Setters
}
