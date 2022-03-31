package com.lqb.ss.MyShardingSphere.service.app;

import com.lqb.ss.MyShardingSphere.common.DataAngularResult;
import com.lqb.ss.MyShardingSphere.model.app.AppHdrUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
public interface AppHdrUserService extends IService<AppHdrUser> {

    /**
     * date:2021-02-24
     *  分页查询 商品
     *
     * @param page  页码  可以为空
     * @param pagesize 条数  可以为空
     */
    public DataAngularResult<AppHdrUser> searchByPage(Integer page, Integer pagesize);
}
