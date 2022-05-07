package com.hello.storage.mapper;

import com.hello.storage.entity.TStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@Mapper
public interface TStorageMapper extends BaseMapper<TStorage> {

    void decrease(@Param("productId") Integer productId,@Param("count") Integer count);

}
