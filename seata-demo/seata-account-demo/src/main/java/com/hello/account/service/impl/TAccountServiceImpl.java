package com.hello.account.service.impl;

import com.hello.account.entity.TAccount;
import com.hello.account.mapper.TAccountMapper;
import com.hello.account.service.ITAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

    @Autowired
    private TAccountMapper tAccountMapper;

    @Override
    public Object decrease(Integer userId, BigDecimal money) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*try {
            money.divide(new BigDecimal(0));
        } catch (Exception e) {
            throw new RuntimeException("扣除账户余额计算错误");
        }*/
        tAccountMapper.decrease(userId,money);
        Map<String,Object> res_map = new HashMap<>();
        res_map.put("code",200);
        res_map.put("msg","执行成功！");
        return res_map;
    }
}
