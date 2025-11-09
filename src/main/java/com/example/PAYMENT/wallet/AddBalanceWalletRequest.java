package com.example.PAYMENT.wallet;

import java.math.BigDecimal;

public record AddBalanceWalletRequest(Long walletId, BigDecimal amount) {
}
