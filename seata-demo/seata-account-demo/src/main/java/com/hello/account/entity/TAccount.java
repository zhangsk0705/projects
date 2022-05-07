package com.hello.account.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author system
 * @since 2022-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 总金额
     */
    private BigDecimal money;

    /**
     * 使用金额
     */
    private BigDecimal used;

    /**
     * 剩余金额
     */
    private BigDecimal remain;


}
