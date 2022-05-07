package com.hello.order.service;

import com.hello.order.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
public interface ITOrderService extends IService<TOrder> {

    Object create(TOrder order);
}
