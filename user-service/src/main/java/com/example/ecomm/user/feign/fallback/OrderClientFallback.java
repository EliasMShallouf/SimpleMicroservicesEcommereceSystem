package com.example.ecomm.user.feign.fallback;

import com.example.ecomm.user.domain.model.dto.OrderDTO;
import com.example.ecomm.user.feign.client.OrderClient;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderClientFallback implements OrderClient {
    public OrderClientFallback() {
        System.err.println("Feign error");
    }

    @Override
    public Double getUserTotal(String userId) {
        return 0.0;
    }

    @Override
    public List<OrderDTO> getUserOrdersHistory(String usedId) {
        return new ArrayList<>();
    }

    @Override
    public OrderDTO createOrder(OrderDTO order) {
        return order;
    }

    @Override
    public String serverInfo() {
        return "null";
    }
}
