package com.example.PAYMENT

import com.example.PAYMENT.transaction.PaymentTransactionRequest
import com.example.PAYMENT.transaction.PaymentTransactionResponse
import com.example.PAYMENT.transaction.TransactionService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@ExtendWith(SpringExtension)
class TransactionServiceIntgTest {
    @Autowired
    TransactionService transactionService;

    @Test
    @Transactional
    public void 결제를생성한다() {
        // given
        PaymentTransactionRequest request = new PaymentTransactionRequest(
                1L, "course-1", new BigDecimal(10)
        );

        // when
        PaymentTransactionResponse response = transactionService.payment(request);

        // then
        Assertions.assertNotNull(response);
        System.out.println(response);
    }
}
