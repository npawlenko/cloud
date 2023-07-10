package com.example.user.user;

import com.example.user.model.PaymentCreationRequest;
import com.example.user.model.PaymentCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/{id}/payments")
    public PaymentCreationResponse createPayment(@PathVariable Long id, @RequestBody PaymentCreationRequest paymentCreationRequest) {
        paymentCreationRequest.setUserId(id);
        return service.createPayment(paymentCreationRequest);
    }
}
