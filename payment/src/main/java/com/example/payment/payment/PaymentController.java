package com.example.payment.payment;

import com.example.payment.model.PaymentCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    @GetMapping("/{id}")
    public Payment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Payment> findByUserId(@RequestParam Long userId) {
        return service.findByUserId(userId);
    }

    @PostMapping
    public Payment createPayment(@RequestBody PaymentCreationRequest paymentCreationRequest) {
        return service.createPayment(paymentCreationRequest);
    }
}
