package com.example.ecomm.order.service.api;

import com.example.ecomm.order.domain.model.Order;
import com.example.ecomm.order.service.db.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
//@CrossOrigin({ "user-service" })
public class OrderEndpointService {
    @Autowired
    private OrderService orderService;

    @Value("${eureka.instance.instanceId}")
    private String serverInfo;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getUserOrdersHistory(@RequestParam("userId") String userId) {
        return orderService.getUserOrdersHistory(userId);
    }

    @GetMapping("/total")
    public Double getUserTotal(@RequestParam("userId") String userId) throws Exception {
        return orderService.getUserTotal(userId);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") String orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/server")
    public String serverInfo() {
        return serverInfo;
    }
}
