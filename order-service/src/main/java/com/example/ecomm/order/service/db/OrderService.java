package com.example.ecomm.order.service.db;

import com.example.ecomm.order.domain.model.Order;
import com.example.ecomm.order.domain.model.repository.OrderLineRepository;
import com.example.ecomm.order.domain.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    public List<Order> getUserOrdersHistory(String userId) {
        return orderRepository.getUserOrdersHistory(userId);
    }

    public Double getUserTotal(String userId) throws Exception {
        Double total = orderRepository.getUserTotal(userId);
        if(total == null)
            throw new RuntimeException("User have not made any order!");

        return total;
    }

    public void createOrder(Order order) {
        final Order savedOrder = orderRepository.save(order);
        order.getLines().forEach(line -> line.setOrderId(savedOrder.getId()));
        orderLineRepository.saveAll(order.getLines());
    }

    @Transactional
    public void deleteOrder(String orderId) {
        orderLineRepository.deleteOrder(orderId);
        orderRepository.deleteById(orderId);
    }
}
