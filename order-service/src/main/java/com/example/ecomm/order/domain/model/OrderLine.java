package com.example.ecomm.order.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Table
@Entity
public class OrderLine implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @Column(name = "line_number") private Integer lineNumber;
    @Column(name = "order_id") private String orderId;
    @Column(name = "product_id") private String productId;
    @Column private Double price;
    @Column private Double qty;
    @Column private Double discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", lineNumber=" + lineNumber +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", discount=" + discount +
                '}';
    }
}
