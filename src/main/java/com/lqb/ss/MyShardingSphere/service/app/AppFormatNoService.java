package com.lqb.ss.MyShardingSphere.service.app;

import com.lqb.ss.MyShardingSphere.model.app.AppFormatNo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 业务单据单号表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-16
 */
public interface AppFormatNoService extends IService<AppFormatNo> {

    /**
     * date:2021-02-25
     * 根据code获取表单单号
     * @param  code 编号 不能为空
     * @return Map
     *          code -200 失败 200成功
     *          msg 信息
     *          orderNo 单号
     * */
    public Map<String,String> getOrderNo(String code);

}
