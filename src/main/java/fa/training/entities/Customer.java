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

    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
