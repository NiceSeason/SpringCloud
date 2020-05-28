package io.niceseason.spring.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.niceseason.spring.cloud.entities.CommonResult;
import io.niceseason.spring.cloud.entities.Payment;
import io.niceseason.spring.cloud.handler.MyBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            int i=1/0;
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "----testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2) {
        return "----testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "----deal_testHotKey, o(╥﹏╥)o"; // sentinel的默认提示都是： Blocked by Sentinel (flow limiting)
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerFun")
    public CommonResult<String> byResource() {
        return new CommonResult<String>(200, "按照资源限流", "test001");
    }

    public CommonResult<String> handlerFun(BlockException exception) {
        return new CommonResult<>(444, exception.getMessage(), "handfun001");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return  new CommonResult(200,"按照byUrl限流测试",new Payment(2020L,"serial002"));
    }

    @GetMapping("/handlerClass")
    @SentinelResource(value = "handlerClass",blockHandlerClass = {MyBlockHandler.class},blockHandler = "handlerBlock")
    public CommonResult<String> handlerClass() {
        return new CommonResult<String>(200, "测试自定义block处理类", "handlerClass");
    }
}


