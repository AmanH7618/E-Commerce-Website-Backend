package com.notification.notification;

import lombok.Getter;
import org.apache.kafka.common.protocol.types.Field;

public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Payment successfully processed")
    ;
    @Getter
    private final String template;
    @Getter
    private final String subject;
    EmailTemplates(String template, String subject){
        this.template = template;
        this.subject = subject;
    }
}
