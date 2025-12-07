package com.example.PAYMENT.wallet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findTopByUserId(Long userId);
    Optional<Wallet> findAllByUserId(Long userId);
}
