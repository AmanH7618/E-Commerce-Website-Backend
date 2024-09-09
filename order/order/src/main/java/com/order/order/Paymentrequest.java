package com.order.order;

import java.math.BigDecimal;

public record Paymentrequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
