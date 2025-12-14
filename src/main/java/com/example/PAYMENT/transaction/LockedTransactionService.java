package com.example.PAYMENT.transaction;

import com.example.PAYMENT.WalletLockerService;
import com.example.PAYMENT.wallet.FindWalletResponse;
import com.example.PAYMENT.wallet.WalletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class LockedTransactionService {
    private final WalletLockerService walletLockerService;
    private final WalletService walletService;
    private final TransactionService transactionService;

    @Transactional
    public ChargeTransactionResponse charge(ChargeTransactionRequest request) {
        final FindWalletResponse findWalletResponse = walletService
                .findWalletByUserId(request.userId());
        // 월렛에 락을 걸었음.
        WalletLockerService.Lock lock =
                walletLockerService.acquireLock(findWalletResponse.id());
        if (lock == null) {
            log.info("락 취득 실패");
            throw new IllegalStateException("cannot get lock");
        }

        try {
            log.info("락 취득 성공");
            return transactionService.charge(request);
        } finally {
            walletLockerService.releaseLock(lock);
        }
    }
}
