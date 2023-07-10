package com.example.user.clients;

import com.example.user.model.PaymentCreationRequest;
import com.example.user.model.PaymentCreationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "${payment-service.client.url}/api/v1/payments")
public interface PaymentClient {
    @PostMapping
    PaymentCreationResponse createPayment(@RequestBody PaymentCreationRequest paymentCreationRequest);
}
