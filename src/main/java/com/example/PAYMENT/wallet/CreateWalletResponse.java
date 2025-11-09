package com.example.PAYMENT.wallet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateWalletResponse(
        Long id, Long userId, BigDecimal balance
) {
}
