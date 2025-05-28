package model;

import enums.ProductStatusEnum;

public class Product extends Modal {
    private int id;
    private String name;
    private int price;
    private ProductStatusEnum status;

    public Product(int id, String name, int price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = ProductStatusEnum.getEnum(status);
    }

    public Product(int price, String name, ProductStatusEnum productStatusEnum) {
        this.price = price;
        this.name = name;
        this.status = productStatusEnum;
    }

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProductStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    @Override
    public String toColumn() {
        return "id,name,price,status";
    }

    @Override
    public String toColumnValue() {
        return id + comma + name + comma + price + status;
    }
}
