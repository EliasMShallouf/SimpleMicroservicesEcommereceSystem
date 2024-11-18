package com.example.ecomm.order.domain.model.repository;

import com.example.ecomm.order.domain.model.OrderLine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
    @Modifying
    @Query("delete from OrderLine ol where ol.orderId = :orderId")
    void deleteOrder(@Param("orderId") String orderId);
}
