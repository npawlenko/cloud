package com.example.payment.clients;

import com.example.payment.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service", url = "${user-service.client.url}")
@RequestMapping("/api/v1/users")
public interface UserClient {
    @GetMapping("/{id}")
    UserResponse findById(@PathVariable Long id);
}
