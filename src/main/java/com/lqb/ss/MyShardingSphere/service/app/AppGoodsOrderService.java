package com.lqb.ss.MyShardingSphere.service.app;


import com.lqb.ss.MyShardingSphere.common.Message;
import com.lqb.ss.MyShardingSphere.model.app.AppGoodsOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品订单表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-15
 */
public interface AppGoodsOrderService extends IService<AppGoodsOrder> {


    /**
     * date:2021-02-24
     *  分页查询 商品
     *
     * @param userId 用户id  不能为空
     * @param page  页码  可以为空
     * @param pagesize 条数  可以为空
     */
    public Message searchByPage(String userId , Integer page, Integer pagesize);

    /**
     * date:2021-04-20
     * 添加人和订单测试分布事物
     *
     */
    Message addUserAndGoodsOrder();
}
