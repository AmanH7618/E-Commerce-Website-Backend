package com.payment.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
    String id,
    @NotNull(message = "name should be provided")
    String firstname,
    @NotNull(message = "name should be provided")
    String lastname,
    @NotNull(message = "email should be provided")
    @Email(message = "mail is incorrect")
    String email){
}
