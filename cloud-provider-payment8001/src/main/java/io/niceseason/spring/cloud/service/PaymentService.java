package io.niceseason.spring.cloud.service;

import io.niceseason.spring.cloud.entities.Payment;

public interface PaymentService {

     int create(Payment payment);

     Payment getPaymentById(Long id);
}
