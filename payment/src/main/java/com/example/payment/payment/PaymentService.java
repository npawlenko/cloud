package com.example.payment.payment;

import com.example.payment.clients.UserClient;
import com.example.payment.exception.PaymentNotFoundException;
import com.example.payment.model.PaymentCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private UserClient user;

    public Payment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

    public List<Payment> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Payment createPayment(PaymentCreationRequest paymentCreationRequest) {
        UUID uuid = UUID.randomUUID();
        Payment payment = new Payment(
                0L,
                paymentCreationRequest.getUserId(),
                uuid,
                paymentCreationRequest.getTotal(),
                paymentCreationRequest.getCurrency(),
                LocalDate.now().plusDays(7),
                "http://payhere.com/pay?uuid=" + uuid
        );

        return repository.save(payment);
    }
}
