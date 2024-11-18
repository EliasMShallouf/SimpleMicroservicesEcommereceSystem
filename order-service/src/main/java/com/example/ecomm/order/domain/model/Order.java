package com.example.ecomm.order.domain.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "SalesOrder")
@Entity
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private String id;
    @Column(name = "user_id") private String userId;
    @Column(name = "order_date") private Date orderDate;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> lines = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", orderDate=" + orderDate +
                ", lines=" + lines +
                '}';
    }
}
