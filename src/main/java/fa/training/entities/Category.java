package fa.training.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "categories", schema = "dbo", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}, indexes = {
        @Index(name = "idx_category_name", columnList = "name")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
