package com.hello.order.service.impl;

import com.hello.order.entity.TOrder;
import com.hello.order.mapper.TOrderMapper;
import com.hello.order.service.ITAccountService;
import com.hello.order.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.order.service.ITStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@Slf4j
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private ITStorageService itStorageService;

    @Autowired
    private ITAccountService itAccountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "seata-create-order",rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public Object create(TOrder order){
        log.info("===> 开始创建订单！");
        log.info("===> order:{}",order);
        tOrderMapper.insert(order);
        log.info("===> 订单创建成功！");

        log.info("===> 开始扣除库存！");
        log.info("===> productId:{},count:{}",order.getProductId(),order.getCount());
        Map<String,Object> storage_res = (Map<String, Object>) itStorageService.decrease(order.getProductId(), order.getCount());
        log.info("===> code:{},msg:{}",storage_res.get("code"),storage_res.get("msg"));
        log.info("===> 扣除库存成功！");

        log.info("===> 开始扣除账户余额！");
        log.info("===> userId:{},money:{}",order.getUserId(),order.getMoney());
        Map<String,Object> account_res = (Map<String, Object>) itAccountService.decrease(order.getUserId(), order.getMoney());
        log.info("===> code:{},msg:{}",account_res.get("code"),account_res.get("msg"));
        log.info("===> 扣除账户余额成功！");

        log.info("===> 开始修改订单状态！");
        order.setState(1);
        tOrderMapper.updateById(order);
        log.info("===> 修改订单状态成功！");

        Map<String,Object> res_map = new HashMap<>();
        res_map.put("code",200);
        res_map.put("msg","执行成功！");
        return res_map;
    }

}
