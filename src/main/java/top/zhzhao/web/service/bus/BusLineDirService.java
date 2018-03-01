/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus;

import com.baomidou.mybatisplus.service.IService;
import top.zhzhao.web.model.bus.entity.BusLineDir;

/**
 *
 *@author zhzhao
 *@version $ Id: BusLineDirService.java,V 0.1 2018/2/9 14:15 zhzhao Exp $
 */
public interface BusLineDirService extends IService<BusLineDir> {
    void truncate();
    String findDefDirByName(String lineName);
}
