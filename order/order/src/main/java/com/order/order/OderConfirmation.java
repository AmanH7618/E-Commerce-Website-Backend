package com.order.order;

import java.util.List;

public record OderConfirmation(
        String orderReference,
        java.math.@jakarta.validation.constraints.Positive(message = "amount must be positive") BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
