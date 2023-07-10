package com.example.payment.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p WHERE p.uuid = :uuid")
    Optional<Payment> findByUuid(@Param("uuid") UUID uuid);

    @Query("SELECT p FROM Payment p WHERE p.userId = :userId")
    List<Payment> findByUserId(@Param("userId") Long userId);
}
