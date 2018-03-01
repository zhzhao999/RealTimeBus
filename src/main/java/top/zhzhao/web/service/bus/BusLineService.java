/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus;

import com.baomidou.mybatisplus.service.IService;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusUser;

import java.io.IOException;

/**
 * 普通线路服务
 *@author zhzhao
 *@version $ Id: BusLineService.java,V 0.1 2018/1/22 20:02 zhzhao Exp $
 */
public interface BusLineService extends IService<BusLine> {
    void updateLine() throws IOException;
    void updateDir() throws IOException;
}
