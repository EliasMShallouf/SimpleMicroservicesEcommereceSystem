package com.example.ecomm.user.feign.fallback.factory;

import com.example.ecomm.user.feign.client.OrderClient;
import com.example.ecomm.user.feign.fallback.OrderClientFallback;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderClientFallbackFactory implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable cause) {
        return new OrderClientFallback();
    }
}
