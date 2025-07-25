package fa.training.dtos;

public class ProductDetailsDTO {
    private Long id;
    private String color;
    private String size;
    private Double weight;

    public ProductDetailsDTO() {
    }

    public ProductDetailsDTO(Long id, String color, String size, Double weight) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
