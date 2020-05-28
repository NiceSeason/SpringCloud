package io.niceseason.spring.cloud.service;

import io.niceseason.spring.cloud.entities.CommonResult;
import io.niceseason.spring.cloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "feign服务降级", null);
    }
}
