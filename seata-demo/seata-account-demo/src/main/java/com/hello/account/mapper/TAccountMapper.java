package com.hello.account.mapper;

import com.hello.account.entity.TAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@Mapper
public interface TAccountMapper extends BaseMapper<TAccount> {

    void decrease(@Param("userId") Integer userId,@Param("money") BigDecimal money);

}
