package com.notification.notification;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.notification.notification.NotificationType.ORDER_CONFIRMATION;
import static com.notification.notification.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(String.format("Consuming the message from payment topic:: %s",paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationdate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );
    }

        @KafkaListener(topics = "order-topic")
        public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
            log.info(String.format("Consuming the message from payment topic:: %s",orderConfirmation));
            repository.save(
                    Notification.builder()
                            .type(ORDER_CONFIRMATION)
                            .notificationdate(LocalDateTime.now())
                            .orderConfirmation(orderConfirmation)
                            .build()
            );
            var customerName = orderConfirmation.customer().firstname() + " " + orderConfirmation.customer().lastname();
            emailService.sendPaymentSuccessEmail(
                    orderConfirmation.customer().email(),
                    customerName,
                    orderConfirmation.totalAmount(),
                    orderConfirmation.orderReference()
            );
    }
}
