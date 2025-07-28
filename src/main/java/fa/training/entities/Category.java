package fa.training.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "categories", schema = "dbo", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}, indexes = {
        @Index(name = "idx_category_name", columnList = "name")
})
public class Category extends EntityBase {

    @Column(name = "name", nullable = false, length = 100, columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "description", nullable = false, length = 200, columnDefinition = "nvarchar(200)")
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
