/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhzhao.web.mapper.bus.BusCollectMapper;
import top.zhzhao.web.mapper.bus.BusLineMapper;
import top.zhzhao.web.model.bus.entity.BusCollect;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.service.bus.BusCollectService;

/**
 * 用户收藏服务
 *@author zhzhao
 *@version $ Id: BusCollectServiceImpl.java,V 0.1 2018/1/27 18:09 zhzhao Exp $
 */
@Service
public class BusCollectServiceImpl extends ServiceImpl<BusCollectMapper,BusCollect>
        implements BusCollectService {

    @Override
    public BusCollect collect(String userId,String lineId, String dirId, String stopId) {
        //TODO  用户收藏

        return null;
    }
}
