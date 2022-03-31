package com.lqb.ss.MyShardingSphere.service.app.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lqb.ss.MyShardingSphere.model.app.AppFormatNo;
import com.lqb.ss.MyShardingSphere.dao.app.AppFormatNoMapper;
import com.lqb.ss.MyShardingSphere.service.app.AppFormatNoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 * 业务单据单号表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2021-04-16
 */
@Service
public class AppFormatNoServiceImpl extends ServiceImpl<AppFormatNoMapper, AppFormatNo> implements AppFormatNoService {

    @Override
    public synchronized Map<String, String> getOrderNo(String code) {
        log.debug("AppFormatNoServiceImpl.getOrderNo  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  code = " + code );
        Map<String,String> map  = new HashMap<String,String>();
        if (StringUtils.isNotEmpty(code)) {
            List<AppFormatNo> orderNoList =  baseMapper.selectList(new QueryWrapper<AppFormatNo>().eq("code",code));
            if (orderNoList!=null && orderNoList.size() > 0 ) {
                AppFormatNo orderNo = orderNoList.get(0);
                if (orderNo!=null) {
                    String prefix =  orderNo.getPrefix();
                    String dateFormat =  orderNo.getDateFormat();
                    String digit =  orderNo.getDigit();
                    Integer start =  orderNo.getStart();
                    SimpleDateFormat sFormat = new SimpleDateFormat(dateFormat);
                    NumberFormat nf = NumberFormat.getInstance();
                    //设置是否使用分组
                    nf.setGroupingUsed(false);
                    //设置最小整数位数
                    nf.setMinimumIntegerDigits(Integer.parseInt(digit));
                    Date date = new Date();
                    String order = prefix+ sFormat.format(date) + nf.format(start + 1);
                    orderNo.setStart(orderNo.getStart()+1);
                    orderNo.setVersion(orderNo.getVersion());
                    int updateSum = baseMapper.update(orderNo,new QueryWrapper<AppFormatNo>().eq("id",orderNo.getId()));
                    if (updateSum>0) {
                        map.put("code","200");
                        map.put("orderNo",order);
                        map.put("msg","获取成功！");
                    } else {
                        map.put("code","-200");
                        map.put("msg","更新数据失败！");
                    }
                }else {
                    map.put("code","-200");
                    map.put("msg","获取数据失败！");
                }
            } else {
                map.put("code","-200");
                map.put("msg","根据code无法查询到数据！");
            }
        } else {
            map.put("code","-200");
            map.put("msg","code不能为空！");
        }
        log.debug(" map = " + map.toString());
        log.debug("AppFormatNoServiceImpl.getOrderNo  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return map;
    }
}
