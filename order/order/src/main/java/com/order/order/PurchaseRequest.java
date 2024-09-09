package com.order.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product s mandatory")
        Integer productId,
        @Positive(message = "quantity must be positive")
        double quanity

) {
}
