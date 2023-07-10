package com.example.user.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreationResponse {
    private Long id;
    private Long userId;
    private UUID uuid;
    private double total;
    private String currency;
    private LocalDate expires;
    private String link;
}
