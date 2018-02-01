/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus;

import com.baomidou.mybatisplus.service.IService;
import top.zhzhao.web.model.bus.entity.BusCollect;
import top.zhzhao.web.model.bus.entity.BusLine;

import java.io.IOException;

/**
 * 用户收藏服务
 */
public interface BusCollectService extends IService<BusCollect> {
    BusCollect collect(String userId,String lineId, String dirId, String stopId);
}
