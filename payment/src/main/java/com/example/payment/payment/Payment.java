package com.example.payment.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private Long userId;
    @Column(unique = true)
    private UUID uuid;
    private double total;
    private String currency;
    private LocalDate expires;
    private String link;
}
