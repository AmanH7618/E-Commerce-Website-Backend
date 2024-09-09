package com.notification.notification;

import org.apache.kafka.common.protocol.types.Field;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String id,
        String customerFirstname,
        String customerLastname,
        String customerEmail

) {
}
