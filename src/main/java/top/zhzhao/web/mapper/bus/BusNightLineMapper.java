/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.mapper.bus;

import org.apache.ibatis.annotations.Mapper;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusNightLine;
import top.zhzhao.web.utils.SupperMapper.SuperMapper;

/**
 *
 *@author zhzhao
 *@version $ Id: BusNightLineMapper.java,V 0.1 2018/1/22 20:08 zhzhao Exp $
 */
@Mapper
public interface BusNightLineMapper extends SuperMapper<BusNightLine> {
}
