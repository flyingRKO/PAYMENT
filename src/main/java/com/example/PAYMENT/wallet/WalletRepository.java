package com.example.PAYMENT.wallet;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findTopByUserId(Long userId);
    Optional<Wallet> findAllByUserId(Long userId);
}
