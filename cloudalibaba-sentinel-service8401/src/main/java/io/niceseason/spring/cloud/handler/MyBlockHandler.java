package io.niceseason.spring.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.niceseason.spring.cloud.entities.CommonResult;

public class MyBlockHandler {
    public static CommonResult<String> handlerBlock(BlockException exception) {
        return new CommonResult<>(444, exception.getMessage(), "handlerBlock");
    }

}
