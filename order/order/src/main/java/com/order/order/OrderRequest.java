package com.order.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(Integer id,
                           String reference,
                           @Positive(message = "amount must be positive")
                           BigDecimal amount,
                           @NotNull(message = "Payment method should be precise")
                           PaymentMethod paymentMethod,
                           @NotNull(message = "Customer id should be precise")
                           @NotBlank(message = "Payment method should be precise")
                           @NotEmpty(message = "Payment method should be precise")
                           String customerId,
                           @NotEmpty(message = "Buy atleast one product")
                           List<PurchaseRequest> products
) {


}
