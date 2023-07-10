package com.example.user.user;

import com.example.user.clients.PaymentClient;
import com.example.user.exception.UserNotFoundException;
import com.example.user.model.PaymentCreationRequest;
import com.example.user.model.PaymentCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PaymentClient payment;


    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PaymentCreationResponse createPayment(PaymentCreationRequest paymentCreationRequest) {
        User u = findById(paymentCreationRequest.getUserId());
        return payment.createPayment(paymentCreationRequest);
    }
}
