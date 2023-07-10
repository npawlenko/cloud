package com.example.user.user;

import com.example.user.model.PaymentCreationRequest;
import com.example.user.model.PaymentCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PostMapping("/{id}/payments")
    public PaymentCreationResponse createPayment(@PathVariable Long id, @RequestBody PaymentCreationRequest paymentCreationRequest) {
        paymentCreationRequest.setUserId(id);
        return service.createPayment(paymentCreationRequest);
    }
}
