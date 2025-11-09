package com.example.PAYMENT;

import com.example.PAYMENT.wallet.CreateWalletRequest;
import com.example.PAYMENT.wallet.CreateWalletResponse;
import com.example.PAYMENT.wallet.WalletService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WalletServiceIntgTest {
    @Autowired
    WalletService walletService;

    @Test
    @Transactional
    public void 지갑을생성한다() {
        // given
        CreateWalletRequest request = new CreateWalletRequest(1001L);

        // when
        CreateWalletResponse response = walletService.createWallet(request);

        // then
        Assertions.assertNotNull(response);
        System.out.println(response);
    }
}
