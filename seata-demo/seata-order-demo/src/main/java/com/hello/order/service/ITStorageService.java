package com.hello.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zsk
 * @version 1.0
 * @date 2022-04-30 16:37
 */
@FeignClient(name = "${interface.storage.serverName}",url = "${interface.storage.serverHost}")
public interface ITStorageService {
    // 扣除库存
    @GetMapping("/api/decrease")
    Object decrease(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
