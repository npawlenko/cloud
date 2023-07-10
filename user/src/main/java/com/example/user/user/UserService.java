package com.example.user.user;

import com.example.user.clients.PaymentClient;
import com.example.user.exception.UserNotFoundException;
import com.example.user.model.PaymentCreationRequest;
import com.example.user.model.PaymentCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final PaymentClient payment;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PaymentCreationResponse createPayment(PaymentCreationRequest paymentCreationRequest) {
        User u = findById(paymentCreationRequest.getUserId());
        return payment.createPayment(paymentCreationRequest);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User createUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreatedAt(LocalDate.now());
        return repository.save(user);
    }
}
