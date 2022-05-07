package com.hello.storage.service.impl;

import com.hello.storage.entity.TStorage;
import com.hello.storage.mapper.TStorageMapper;
import com.hello.storage.service.ITStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
@Transactional(rollbackFor = Exception.class)
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements ITStorageService {

    @Autowired
    private TStorageMapper tStorageMapper;

    @Override
    public Object decrease(Integer productId,Integer count){
        tStorageMapper.decrease(productId,count);
        Map<String,Object> res_map = new HashMap<>();
        res_map.put("code",200);
        res_map.put("msg","执行成功！");
        return res_map;
    }

}
