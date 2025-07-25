package fa.training.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers", schema = "dbo")
public class Customer extends EntityBase {

    @Column(name = "first_name", length = 50, columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "last_name", length = 50, columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "address", length = 200, columnDefinition = "nvarchar(200)")
    private String address;

    // Constructors, Getters & Setters
}
