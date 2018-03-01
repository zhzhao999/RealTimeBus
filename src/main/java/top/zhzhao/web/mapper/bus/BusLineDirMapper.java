/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.mapper.bus;

import org.apache.ibatis.annotations.Mapper;
import top.zhzhao.web.model.bus.entity.BusLineDir;
import top.zhzhao.web.utils.SupperMapper.SuperMapper;

/**
 * 线路方向
 *@author zhzhao
 *@version $ Id: BusLineDirMapper.java,V 0.1 2018/2/9 14:14 zhzhao Exp $
 */
@Mapper
public interface BusLineDirMapper extends SuperMapper<BusLineDir> {
    void truncate();
    String findDefDirByName(String lineName);
}
