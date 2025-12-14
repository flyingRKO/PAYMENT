package com.example.PAYMENT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WalletLockerServiceIntgTest {
    @Autowired
    WalletLockerService walletLockerService;

    @Test
    public void test_acquire_lock() {
        WalletLockerService.Lock lock = walletLockerService.acquireLock(1L);
        System.out.println(lock);
        System.out.println(walletLockerService.acquireLock(1L));

        walletLockerService.releaseLock(lock);
        System.out.println(walletLockerService.acquireLock(1L));
    }
}
