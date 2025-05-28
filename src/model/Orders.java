package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Orders extends Modal {
    private int id;
    private Date orderDate;
    private int totalAmount;
    private Timestamp createAt;
    private Timestamp updateAt;
    private final String comma = ",";

    public Orders(Date orderDate, int totalAmount) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Orders(int id, Date orderDate, int totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Orders(Date orderDate, int totalAmount, Timestamp createAt, Timestamp updateAt) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Orders(int id, Date orderDate, int totalAmount, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public String toColumn() {
        return "id,orderDate,totalAmount,createAt,updateAt";
    }

    @Override
    public String toColumnValue() {
        return id + comma + orderDate + comma + totalAmount + comma + createAt + comma + updateAt;
    }
}
