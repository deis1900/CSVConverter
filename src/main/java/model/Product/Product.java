package model.Product;


public class Product {
    private Long id;
    private String category;
    private String material;
    private String size;
    private String color;
    private String image;
    private Long dateOfLastChange;
    private Double price;

    public Product() { }

    public Product(Long id, String category, String material,
                   String size, String color, String image, Long dateOfLastChange, Double price) {
        this.id = id;
        this.category = category;
        this.material = material;
        this.size = size;
        this.color = color;
        this.image = image;
        this.dateOfLastChange = dateOfLastChange;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    void setImage(String image) {
        this.image = image;
    }

    public Long getDateOfLastChange() {
        return dateOfLastChange;
    }

    void setDateOfLastChange(Long dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }

    public Double getPrice() {
        return price;
    }

    void setPrice(Double price) {
        this.price = price;
    }

    public Boolean toCompare(String str) {
        String customerHeader = "id,category,material,size,color,dateoflastchange,price,image";
        return customerHeader.equals(str);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", material='" + material + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", image='" + image + '\'' +
                ", dateOfLastChange=" + dateOfLastChange +
                ", price=" + price +
                '}';
    }
}
