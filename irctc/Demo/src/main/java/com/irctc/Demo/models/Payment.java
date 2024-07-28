package com.irctc.Demo.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Payment {
    Ticket ticket;
    PaymentStatus status;
    PaymentMode paymentMode;
    long referenceNumber;
}
