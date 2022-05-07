package com.hello.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zsk
 * @version 1.0
 * @date 2022-04-30 16:43
 */
@FeignClient(name = "${interface.account.serverName}",url = "${interface.account.serverHost}")
public interface ITAccountService {
    // 扣除账户余额
    @GetMapping("/api/decrease")
    Object decrease(@RequestParam("userId") Integer userId,@RequestParam("money") BigDecimal money);
}
