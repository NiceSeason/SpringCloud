package io.niceseason.spring.cloud.controller;

import io.niceseason.spring.cloud.domain.CommonResult;
import io.niceseason.spring.cloud.domain.Order;
import io.niceseason.spring.cloud.servcie.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }


}


