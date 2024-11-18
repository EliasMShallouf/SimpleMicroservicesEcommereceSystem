package com.example.ecomm.user.feign.client;

import com.example.ecomm.user.domain.model.dto.OrderDTO;
import com.example.ecomm.user.feign.fallback.OrderClientFallback;
import com.example.ecomm.user.feign.fallback.factory.OrderClientFallbackFactory;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.aspectj.weaver.ast.Or;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(
    value = "order-service", // or "api-gateway"
    path = "api/v1/orders"
    //fallback = OrderClientFallback.class,
    //fallbackFactory = OrderClientFallbackFactory.class
)
@RibbonClient("order-service")
public interface OrderClient {
    @GetMapping("/total")
    @CircuitBreaker(name = "getUserTotalCircuitBreaker", fallbackMethod = "getUserTotalFallback")
    Double getUserTotal(@RequestParam("userId") String userId);

    @GetMapping
    @CircuitBreaker(name = "getUserOrdersHistoryCircuitBreaker", fallbackMethod = "getUserOrdersHistoryFallback")
    List<OrderDTO> getUserOrdersHistory(@RequestParam("userId") String usedId);

    @PostMapping
    @CircuitBreaker(name = "createOrderCircuitBreaker", fallbackMethod = "createOrderFallback")
    OrderDTO createOrder(@RequestBody OrderDTO order);

    @GetMapping("/server")
    @CircuitBreaker(name = "serverInfoCircuitBreaker", fallbackMethod = "serverInfoFallback")
    String serverInfo();

    default Double getUserTotalFallback(Exception e) {
        System.err.println(e.getMessage());
        return 0.0;
    }

    default List<OrderDTO> getUserOrdersHistoryFallback(Exception e) {
        System.err.println(e.getMessage());
        return new ArrayList<>();
    }

    default OrderDTO createOrderFallback(Exception e) {
        System.err.println(e.getMessage());
        return null;
    }

    default String serverInfoFallback(Exception e) {
        System.err.println(e.getMessage());
        return "null";
    }
}
