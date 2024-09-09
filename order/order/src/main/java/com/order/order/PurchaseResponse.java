package com.order.order;

import java.math.BigDecimal;

public record PurchaseResponse(
        Integer productid,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
