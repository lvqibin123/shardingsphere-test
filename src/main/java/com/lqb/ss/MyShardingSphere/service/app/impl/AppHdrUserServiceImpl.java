package com.lqb.ss.MyShardingSphere.service.app.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqb.ss.MyShardingSphere.common.DataAngularResult;
import com.lqb.ss.MyShardingSphere.model.app.AppHdrUser;
import com.lqb.ss.MyShardingSphere.dao.app.AppHdrUserMapper;
import com.lqb.ss.MyShardingSphere.service.app.AppHdrUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
@Service
public class AppHdrUserServiceImpl extends ServiceImpl<AppHdrUserMapper, AppHdrUser> implements AppHdrUserService {

    @Override
    public DataAngularResult<AppHdrUser> searchByPage(Integer page, Integer pagesize) {
        log.debug("AppHdrUserServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param : pagesize = " + pagesize );
        DataAngularResult<AppHdrUser> ds = null;
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<AppHdrUser> wrapper = new QueryWrapper<AppHdrUser>();
            wrapper.orderByDesc("index_no");
            List<AppHdrUser> list = baseMapper.selectList(wrapper);
            PageInfo<AppHdrUser> pageInfo = new PageInfo<AppHdrUser>(list);
            ds = new DataAngularResult<AppHdrUser>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("AppHdrUserServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
    }
}
