package io.niceseason.spring.cloud.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import io.niceseason.spring.cloud.dao.PaymentDao;
import io.niceseason.spring.cloud.entities.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
