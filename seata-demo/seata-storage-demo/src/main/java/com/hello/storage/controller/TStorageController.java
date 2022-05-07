package com.hello.storage.controller;


import com.hello.storage.service.ITStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class TStorageController {

    @Autowired
    private ITStorageService itStorageService;

    @GetMapping("/decrease")
    public Object decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count){
        return itStorageService.decrease(productId,count);
    }

}
