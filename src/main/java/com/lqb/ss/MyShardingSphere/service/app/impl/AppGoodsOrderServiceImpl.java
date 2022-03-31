package com.lqb.ss.MyShardingSphere.service.app.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonArray;
import com.lqb.ss.MyShardingSphere.common.DataAngularResult;
import com.lqb.ss.MyShardingSphere.common.Message;
import com.lqb.ss.MyShardingSphere.common.SnowFlakeUtils;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrder;
import com.lqb.ss.MyShardingSphere.dao.app.AppGoodsOrderMapper;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrderCustom;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrderDetail;
import com.lqb.ss.MyShardingSphere.model.app.AppHdrUser;
import com.lqb.ss.MyShardingSphere.service.app.AppFormatNoService;
import com.lqb.ss.MyShardingSphere.service.app.AppGoodsOrderDetailService;
import com.lqb.ss.MyShardingSphere.service.app.AppGoodsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqb.ss.MyShardingSphere.service.app.AppHdrUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.sharding.algorithm.keygen.SnowflakeKeyGenerateAlgorithm;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
//import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品订单表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-15
 */
@Service
public class AppGoodsOrderServiceImpl extends ServiceImpl<AppGoodsOrderMapper, AppGoodsOrder> implements AppGoodsOrderService {

    @Autowired
    private AppGoodsOrderDetailService appGoodsOrderDetailService;

    @Autowired
    private AppHdrUserService appHdrUserService;

    @Autowired
    private AppFormatNoService orderNoService;

    @Autowired
    private AppGoodsOrderDetailService goodsOrderDetailService;

    @Override
    public Message searchByPage(String userId, Integer page, Integer pagesize) {
        log.debug("AppGoodsOrderServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param : pagesize = " + pagesize );
        Message mes = new Message();
        if (page!=null && pagesize!=null && StringUtils.isNotEmpty(userId)) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<AppGoodsOrder> goodsOrderWapper = new QueryWrapper<AppGoodsOrder>();
            goodsOrderWapper.eq("user_id",Long.parseLong(userId));
            goodsOrderWapper.orderByDesc("order_date");
            List<AppGoodsOrder> list = baseMapper.selectList(goodsOrderWapper);
            PageInfo<AppGoodsOrder> pageInfo = new PageInfo<AppGoodsOrder>(list);
            List<String> orderNos = new ArrayList<>();
            List<AppGoodsOrderCustom> customList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                orderNos.add(list.get(i).getOrderNo());
                AppGoodsOrderCustom goodsOrderCustom = new AppGoodsOrderCustom();
                goodsOrderCustom.setId(list.get(i).getId());
                goodsOrderCustom.setVersion(list.get(i).getVersion());
                goodsOrderCustom.setUserId(list.get(i).getUserId());
                goodsOrderCustom.setShopId(list.get(i).getShopId());
                goodsOrderCustom.setDiscount(list.get(i).getDiscount());
                goodsOrderCustom.setOrderNo(list.get(i).getOrderNo());
                goodsOrderCustom.setOrderType(list.get(i).getOrderType());
                goodsOrderCustom.setIsDelete(list.get(i).getIsDelete());
                goodsOrderCustom.setOrderDate(list.get(i).getOrderDate());
                goodsOrderCustom.setStatus(list.get(i).getStatus());
                goodsOrderCustom.setReceiptAddressId(list.get(i).getReceiptAddressId());
                goodsOrderCustom.setDeliveryMoney(list.get(i).getDeliveryMoney());
                goodsOrderCustom.setDeliveryStatus(list.get(i).getDeliveryStatus());
                goodsOrderCustom.setCreateUserId(list.get(i).getCreateUserId());
                goodsOrderCustom.setCreateTime(list.get(i).getCreateTime());
                goodsOrderCustom.setUpdateUserId(list.get(i).getUpdateUserId());
                goodsOrderCustom.setUpdateTime(list.get(i).getUpdateTime());
                goodsOrderCustom.setIndexNo(list.get(i).getIndexNo());
                customList.add(goodsOrderCustom);
            }
            QueryWrapper<AppGoodsOrderDetail> goodsOrderDetailWapper = new QueryWrapper<AppGoodsOrderDetail>();
            goodsOrderDetailWapper.in("order_id",orderNos);
//            goodsOrderDetailWapper.eq("user_id",Long.parseLong(userId));
            goodsOrderDetailWapper.orderByDesc("order_date");
            List<AppGoodsOrderDetail> goodsOrderDetailLists = appGoodsOrderDetailService.list(goodsOrderDetailWapper);

            for (int i = 0; i < customList.size(); i++) {
                List<AppGoodsOrderDetail> goodsOrderDetailList = new ArrayList<>();
                JsonArray array = new JsonArray();
                for (int j = 0; j < goodsOrderDetailLists.size(); j++) {
//                    log.debug(" customList.get(i).getOrderNo() =  " + customList.get(i).getOrderNo());
//                    log.debug(" goodsOrderDetailLists.get(j).getOrderId() =  " + goodsOrderDetailLists.get(j).getOrderId());
//                    log.debug(" customList.get(i).getOrderNo() == goodsOrderDetailLists.get(j).getOrderId() =  " + (customList.get(i).getOrderNo() == goodsOrderDetailLists.get(j).getOrderId()));
//                    if(customList.get(i).getOrderNo().equals(goodsOrderDetailLists.get(j).getOrderId())) {
//                        goodsOrderDetailList.add(goodsOrderDetailLists.get(j));
//                    }
                    if(customList.get(i).getOrderNo().equals(goodsOrderDetailLists.get(j).getOrderId())) {
                        goodsOrderDetailList.add(goodsOrderDetailLists.get(j));
                        array.add(String.valueOf(goodsOrderDetailLists.get(j)));
                    }
                }
                customList.get(i).setGoodsOrderDetail(goodsOrderDetailList);
//                customList.get(i).setGoodsOrderDetailArray(array);
            }
            log.debug( " customList = " + customList.toString());
            mes.setStatus(200);
            mes.setMessage("查询数据成功!");
            mes.setData(new DataAngularResult<AppGoodsOrderCustom>(pageInfo.getTotal(), customList));
        } else {
            mes.setStatus(-200);
            mes.setMessage("获取 分页参数和用户id 失败!");
        }
        log.debug(" mes = " + mes.toString());
        log.debug("AppGoodsOrderServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return mes;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor={RuntimeException.class, Exception.class})
//     @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
//    @ShardingTransactionType(TransactionType.BASE)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    @ShardingSphereTransactionType(TransactionType.BASE)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    public Message addUserAndGoodsOrder() {
        Message mes = new Message();
        log.debug("AppGoodsOrderServiceImpl.addUserAndGoodsOrder  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );

//        Long id = snowflakeKeyGenerateAlgorithm.
        AppHdrUser appHdrUser = new AppHdrUser();
        appHdrUser.setVersion(1);
        appHdrUser.setPassword("123456");
        appHdrUser.setPhone("13698711929");
        appHdrUser.setSuperId("13698711929");
        appHdrUser.setDeduct(0.01f);
        appHdrUser.setType(1);
        appHdrUser.setStype(0);
        appHdrUser.setCheckcode("123456");
        appHdrUser.setUpdatetime(LocalDateTime.now());
        appHdrUser.setBankName("工商银行");
        appHdrUser.setBankNo("123456789");
        appHdrUser.setAccountBankName("王强");
        appHdrUser.setReceivingPhone("13698711929");
        appHdrUser.setReceivingCodePictureImg("1111111111111");
        appHdrUser.setIsAgreeAgreement("1");
        appHdrUser.setIndexNo(101l);
        List<AppGoodsOrder> list = new ArrayList<>();
        List<AppGoodsOrderDetail> goodsOrderDetailList = new ArrayList<>();
        String userId = "1384342126176198648";
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
                    appGoodsOrderDetail.setIsDelete("6666666666666666666666666666666666666666666666666666");
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
        boolean isAddHdrUser = appHdrUserService.save(appHdrUser);
        boolean isSave = this.saveBatch(list);
        boolean isGoodsOrderDetailSave = goodsOrderDetailService.saveBatch(goodsOrderDetailList);
        if (isSave && isGoodsOrderDetailSave && isAddHdrUser ) {
            log.debug("插入成功！");
            mes.setStatus(200);
            mes.setMessage("插入成功!");
        } else {
            log.error("插入失败");
            mes.setStatus(-200);
            mes.setMessage("插入失败!");
        }
        log.debug("AppGoodsOrderServiceImpl.addUserAndGoodsOrder  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return mes;
    }
}
