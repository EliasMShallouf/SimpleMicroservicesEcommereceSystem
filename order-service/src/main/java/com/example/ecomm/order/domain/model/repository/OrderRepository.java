package com.example.ecomm.order.domain.model.repository;

import com.example.ecomm.order.domain.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
    @Query("select sum(o.price * o.qty * (1 - o.discount)) total from Order so join OrderLine o on o.orderId = so.id where so.userId = :userId")
    Double getUserTotal(@Param("userId") String userId);

    @Query("select o from Order o where o.userId = :userId order by o.orderDate")
    List<Order> getUserOrdersHistory(@Param("userId") String userId);
}