package model;

public class Recipe {
    private int id;
    private int productId;
    private String name;

    public Recipe(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", productId=" + productId +
                ", name='" + name + '\'' +
                '}';
    }
}
