package com.lqb.ss.MyShardingSphere.controller.app;


import com.lqb.ss.MyShardingSphere.common.DataAngularResult;
import com.lqb.ss.MyShardingSphere.model.app.AppHdrUser;
import com.lqb.ss.MyShardingSphere.service.app.AppHdrUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/appHdrUser")
@Slf4j
public class AppHdrUserController {

    @Autowired
    private AppHdrUserService service;
    /**
     * date:2021-04-14
     *  增加用户
     *
     */
    @RequestMapping(value = "/addUsers",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addUsers() {
        log.debug("AppHdrUserController.addUsers  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
       List<AppHdrUser> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
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
            appHdrUser.setIndexNo(Long.valueOf(i));
            list.add(appHdrUser);
        }
        boolean isInster = service.saveBatch(list);
        if (isInster) {
            log.debug("插入成功！");
        } else {
            log.error("插入失败");
        }
        log.debug("AppHdrUserController.addUsers  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
    }

    /**
     * date:2021-04-14
     *  分页查询 用户表
     *
     * @param pi  页码  可以为空
     * @param ps 条数  可以为空
     */

    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DataAngularResult<AppHdrUser> search(@RequestParam Map<String, String> params) {
        log.debug("AppGoodsController.search  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        int pagenum = Integer.valueOf(params.get("pi"));
        int pagesize = Integer.valueOf(params.get("ps"));
        log.debug("Param : pagenum = " + pagenum );
        log.debug("Param : pagesize = " + pagesize );
        DataAngularResult<AppHdrUser>  dataList = service.searchByPage(pagenum, pagesize);
        log.debug(" dataList "  + dataList.toString());
        log.debug("AppGoodsController.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return dataList;
    }
}
