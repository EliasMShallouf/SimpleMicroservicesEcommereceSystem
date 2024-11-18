package com.example.ecomm.user.service.db;

import com.example.ecomm.user.domain.model.User;
import com.example.ecomm.user.domain.model.dto.OrderDTO;
import com.example.ecomm.user.domain.model.repository.UserRepository;
import com.example.ecomm.user.feign.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderClient orderFeignClient;

    public User login(String email, String password) {
        var user = userRepository.findByEmail(email);

        if (user == null)
            throw new RuntimeException("User not found");

        if (!user.getPassword().equals(password))
            throw new RuntimeException("Password not correct");

        return user;
    }

    public User register(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("User already exists with same email!");

        return userRepository.save(user);
    }

    public Double getUserTotal(String userId) {
        return orderFeignClient.getUserTotal(userId);
    }

    public List<OrderDTO> getUserOrdersHistory(String usedId) {
        return orderFeignClient.getUserOrdersHistory(usedId);
    }

    public OrderDTO createOrder(OrderDTO order) {
        return orderFeignClient.createOrder(order);
    }

    public String orderServerInfo() {
        return orderFeignClient.serverInfo();
    }
}
