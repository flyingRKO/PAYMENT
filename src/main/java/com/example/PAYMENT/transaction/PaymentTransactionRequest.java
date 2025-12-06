package com.example.PAYMENT.transaction;

import java.math.BigDecimal;

public record PaymentTransactionRequest(Long walletId, String courseId, BigDecimal amount) {
}
