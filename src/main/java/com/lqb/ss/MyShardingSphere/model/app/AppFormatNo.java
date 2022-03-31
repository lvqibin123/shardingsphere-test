package com.lqb.ss.MyShardingSphere.model.app;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 业务单据单号表
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppFormatNo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 编号
     */
    private String code;

    /**
     * 单号的前缀
     */
    private String prefix;

    /**
     * 日期格式
     */
    private String dateFormat;

    /**
     * 数据位数
     */
    private String digit;

    /**
     * 开始数
     */
    private Integer start;


}
