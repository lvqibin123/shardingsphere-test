package com.lqb.ss.MyShardingSphere.model.app;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品订单表
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppGoodsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id(自动递增)
     */
    private Long id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 商铺id
     */
    private String shopId;

    /**
     * 商铺省份id
     */
    private String shopProvinceId;

    /**
     * 商铺城市id
     */
    private String shopCityId;

    /**
     * 商铺县id
     */
    private String shopCountyId;

    /**
     * 商铺折扣率
     */
    private Double discount;

    /**
     * 下单人的ID
     */
    private Long userId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 提货码
     */
    private String deliveryCode;

    /**
     * 提货电话号码
     */
    private String deliveryPhone;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 下单时间
     */
    private LocalDateTime orderDate;

    /**
     * 预计送达时间
     */
    private LocalDateTime estimatedDeliveryTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 订单取消原因
     */
    private String reasonCancellation;

    /**
     * 订单取消时间
     */
    private LocalDateTime reasonDate;

    /**
     * 红包金额
     */
    private Double redEnvelopeMoney;

    /**
     * 支付时间
     */
    private LocalDateTime payDate;

    /**
     * 支付方式
     */
    private String payAway;

    /**
     * 支付金额
     */
    private Double payMoney;

    /**
     * 支付订单号
     */
    private String payOrderId;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 收货地址
     */
    private Integer receiptAddressId;

    /**
     * 发货日期
     */
    private LocalDateTime shipmentTime;

    /**
     * 收货日期
     */
    private LocalDateTime receiptTime;

    /**
     * 配送人ID
     */
    private String deliveryUserId;

    /**
     * 配送金额
     */
    private Double deliveryMoney;

    /**
     * 配送时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 配送结束时间
     */
    private LocalDateTime deliveryEndTime;

    /**
     * 配送送达时间
     */
    private LocalDateTime deliveryToTime;

    /**
     * 配送状态
     */
    private String deliveryStatus;

    /**
     * 配送取消原因
     */
    private String deliveryCancellation;

    /**
     * 配送取消时间
     */
    private LocalDateTime deliveryReasonDate;

    /**
     * 商家留言
     */
    private String shopMessage;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    private Long updateUserId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 序号
     */
    private Long indexNo;


}
