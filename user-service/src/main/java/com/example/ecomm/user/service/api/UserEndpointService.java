package com.example.ecomm.user.service.api;

import com.example.ecomm.user.domain.model.User;
import com.example.ecomm.user.domain.model.dto.OrderDTO;
import com.example.ecomm.user.domain.model.request.LoginModel;
import com.example.ecomm.user.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserEndpointService {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody LoginModel loginModel) {
        return userService.login(loginModel.email(), loginModel.password());
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/{userId}/orders/total")
    public Double getUserTotal(@PathVariable("userId") String userId) {
        return userService.getUserTotal(userId);
    }

    @GetMapping("/{userId}/orders")
    public List<OrderDTO> getUserOrdersHistory(@PathVariable("userId") String userId) {
        return userService.getUserOrdersHistory(userId);
    }

    @PostMapping("/{userId}/orders")
    public OrderDTO createOrder(@PathVariable("userId") String userId, @RequestBody OrderDTO order) {
        order.setUserId(userId);
        return userService.createOrder(order);
    }

    @GetMapping("/order-server")
    public String orderServerInfo() {
        return userService.orderServerInfo();
    }
}
