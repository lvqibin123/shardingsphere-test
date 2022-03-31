package com.lqb.ss.MyShardingSphere.controller.app;


import com.lqb.ss.MyShardingSphere.common.Message;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrder;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrderDetail;
import com.lqb.ss.MyShardingSphere.service.app.AppFormatNoService;
import com.lqb.ss.MyShardingSphere.service.app.AppGoodsOrderDetailService;
import com.lqb.ss.MyShardingSphere.service.app.AppGoodsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品订单表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/appGoodsOrder")
@Slf4j
public class AppGoodsOrderController {

    @Autowired
    private AppFormatNoService orderNoService;

    @Autowired
    private AppGoodsOrderService service;

    @Autowired
    private AppGoodsOrderDetailService goodsOrderDetailService;

    /**
     * date:2021-04-14
     *  根据用户id添加订单
     *  @param userId 用户id  不能为空
     *
     */
    @RequestMapping(value = "/addGoodsOrder",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Message addGoodsOrder(@RequestParam Map<String, String> params) {
        log.debug("AppGoodsOrderController.addGoodsOrder  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        Message mes = new Message();
        String userId = params.get("userId");
        if (StringUtils.isNotEmpty(userId)) {

                List<AppGoodsOrder> list = new ArrayList<>();
                List<AppGoodsOrderDetail> goodsOrderDetailList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    Map<String, String> order = orderNoService.getOrderNo("DD");
                    if ("200".equals(order.get("code").toString())) {
                        AppGoodsOrder appGoodsOrder = new AppGoodsOrder();
                        //                appGoodsOrder.setId(orderId);
                        String orderNo = order.get("orderNo").toString();
                        appGoodsOrder.setVersion(1);
                        appGoodsOrder.setUserId(Long.parseLong(userId));
                        appGoodsOrder.setShopId("13698711929");
                        appGoodsOrder.setDiscount(0.9);
                        appGoodsOrder.setOrderNo(orderNo);
                        appGoodsOrder.setOrderType("1");
                        appGoodsOrder.setIsDelete("0");
                        appGoodsOrder.setOrderDate(LocalDateTime.now());
                        appGoodsOrder.setStatus("1");
                        appGoodsOrder.setReceiptAddressId(0);
                        appGoodsOrder.setDeliveryMoney(5.0);
                        appGoodsOrder.setDeliveryStatus("0");
                        appGoodsOrder.setCreateUserId(Long.parseLong(userId));
                        appGoodsOrder.setCreateTime(LocalDateTime.now());
                        appGoodsOrder.setUpdateUserId(Long.parseLong(userId));
                        appGoodsOrder.setUpdateTime(LocalDateTime.now());
                        appGoodsOrder.setIndexNo(Long.valueOf(i));
                        list.add(appGoodsOrder);
                        for (int j = 0; j < 2; j++) {
                            AppGoodsOrderDetail appGoodsOrderDetail = new AppGoodsOrderDetail();
                            appGoodsOrderDetail.setVersion(1);
                            appGoodsOrderDetail.setShopId("13698711929");
                            appGoodsOrderDetail.setUserId(Long.parseLong(userId));
                            appGoodsOrderDetail.setOrderId(orderNo);
                            appGoodsOrderDetail.setGoodCartId(0);
                            appGoodsOrderDetail.setIsDelete("0");
                            appGoodsOrderDetail.setGoodsSum(1);
                            appGoodsOrderDetail.setGoodsPackingPrice(2.00);
                            appGoodsOrderDetail.setGoodsPrice(3.00);
                            appGoodsOrderDetail.setOrderDate(LocalDateTime.now());
                            appGoodsOrderDetail.setCreateUserId(Long.parseLong(userId));
                            appGoodsOrderDetail.setCreateTime(LocalDateTime.now());
                            appGoodsOrderDetail.setUpdateUserId(Long.parseLong(userId));
                            appGoodsOrderDetail.setUpdateTime(LocalDateTime.now());
                            appGoodsOrderDetail.setIndexNo(Long.valueOf(i));
                            appGoodsOrderDetail.setRemark("备注");
                            goodsOrderDetailList.add(appGoodsOrderDetail);
                        }
                    }   else {
                        mes.setStatus(-200);
                        mes.setMessage("获取单号失败！");
                        throw new RuntimeException("获取单号失败！");
                    }
                }
                log.debug(" service = " +  service.toString());
                boolean isSave = service.saveBatch(list);
                boolean isGoodsOrderDetailSave = goodsOrderDetailService.saveBatch(goodsOrderDetailList);
                if (isSave && isGoodsOrderDetailSave ) {
                    log.debug("插入成功！");
                    mes.setStatus(200);
                    mes.setMessage("插入成功!");
                } else {
                    log.error("插入失败");
                    mes.setStatus(-200);
                    mes.setMessage("插入失败!");
                }
        } else {
            mes.setStatus(-200);
            mes.setMessage("获取 userId 失败!");
        };
        log.debug("AppGoodsOrderController.addGoodsOrder  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return  mes;
    }



    /**
     * date:2021-04-14
     *  根据用户id查询订单
     *  @param userId 用户id  不能为空
     * @param pi  页码  不能为空
     * @param ps 条数  不能为空
     *
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Message search(@RequestParam Map<String, String> params) {
        log.debug("AppGoodsOrderController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        String userId = params.get("userId");
        int pagenum = Integer.valueOf(params.get("pi"));
        int pagesize = Integer.valueOf(params.get("ps"));
        log.debug("AppGoodsOrderController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return  service.searchByPage(userId,pagenum,pagesize);
    }

    /**
     * date:2021-04-20
     * 添加人和订单测试分布事物
     *
     */
    @RequestMapping(value = "/addUserAndGoodsOrder",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Message addUserAndGoodsOrder() {
        log.debug("AppGoodsOrderController.addUserAndGoodsOrder  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("AppGoodsOrderController.addUserAndGoodsOrder  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return  service.addUserAndGoodsOrder();
    }

}
