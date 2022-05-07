package com.hello.account.controller;


import com.hello.account.service.ITAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@RestController
@RequestMapping("/api")
public class TAccountController {

    @Autowired
    private ITAccountService itAccountService;

    @GetMapping("/decrease")
    public Object decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money){
        return itAccountService.decrease(userId,money);
    }

}
