package com.hello.storage.service;

import com.hello.storage.entity.TStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
public interface ITStorageService extends IService<TStorage> {

    Object decrease(Integer productId, Integer count);
}
