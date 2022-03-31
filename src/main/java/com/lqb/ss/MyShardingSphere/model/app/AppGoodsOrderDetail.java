package com.lqb.ss.MyShardingSphere.model.app;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品订单明细表
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AppGoodsOrderDetail implements Serializable {

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
     * 商品表id
     */
    private Integer goodsId;

    /**
     * 下单人的ID
     */
    private Long userId;

    /**
     * 订单表id
     */
    private String orderId;

    /**
     * 购物车id
     */
    private Integer goodCartId;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 商品数量
     */
    private Integer goodsSum;

    /**
     * 商品打包费
     */
    private Double goodsPackingPrice;

    /**
     * 商品金额
     */
    private Double goodsPrice;

    /**
     * 下单时间
     */
    private LocalDateTime orderDate;

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
