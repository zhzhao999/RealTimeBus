/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.mapper.bus;

import org.apache.ibatis.annotations.Mapper;
import top.zhzhao.web.model.bus.entity.BusUser;
import top.zhzhao.web.model.bus.entity.base.BusSuperEntity;
import top.zhzhao.web.utils.SupperMapper.SuperMapper;

/**
 *
 *@author zhzhao
 *@version $ Id: BusUserMapper.java,V 0.1 2018/1/22 15:36 zhzhao Exp $
 */
@Mapper
public interface BusUserMapper extends SuperMapper<BusUser>{
}
