package com.lqb.ss.MyShardingSphere.model.app;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppHdrUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号(自动递增)
     */
    private Long id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 密码(保留字段)
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 上级推荐人id
     */
    private String superId;

    /**
     * 抵扣券余额
     */
    private Float deduct;

    /**
     * 0微信注册 1支付宝注册 2其他 
     */
    private Integer stype;

    /**
     * 登录标志（当前登录的是什么类型）0用户 1骑手 2商家
     */
    private Integer type;

    /**
     * 验证码
     */
    private String checkcode;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    /**
     * 开户银行名称
     */
    private String bankName;

    /**
     * 开户银行卡号
     */
    private String bankNo;

    /**
     * 开户人姓名
     */
    private String accountBankName;

    /**
     * 收款人电话
     */
    private String receivingPhone;

    /**
     * 收款码图片
     */
    private String receivingCodePictureImg;

    /**
     * 是否同意协议（0/未同意 1/已同意）
     */
    private String isAgreeAgreement;

    /**
     * 序号
     */
    private Long indexNo;

}
