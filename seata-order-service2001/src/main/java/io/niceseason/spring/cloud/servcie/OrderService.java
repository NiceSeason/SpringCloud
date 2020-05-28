package io.niceseason.spring.cloud.servcie;

import io.niceseason.spring.cloud.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}


