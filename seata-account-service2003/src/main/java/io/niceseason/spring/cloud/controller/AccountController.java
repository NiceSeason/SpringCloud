package io.niceseason.spring.cloud.controller;

import io.niceseason.spring.cloud.domain.CommonResult;
import io.niceseason.spring.cloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }
}


