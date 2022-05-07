package com.hello.account.service;

import com.hello.account.entity.TAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
public interface ITAccountService extends IService<TAccount> {

    Object decrease(Integer userId, BigDecimal money);
}
