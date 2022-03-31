package com.lqb.ss.MyShardingSphere.model.app;

//import com.google.gson.JsonArray;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 商品订单表 扩展
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-15
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class AppGoodsOrderCustom extends AppGoodsOrder {

    /**
     * 商品订单明细数据
     */
    List<AppGoodsOrderDetail> goodsOrderDetail;

    /**
     * 商品订单明细数据json
     */
//    JsonArray goodsOrderDetailArray;

}
