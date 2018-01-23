/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhzhao.web.mapper.bus.BusUserMapper;
import top.zhzhao.web.model.bus.entity.BusUser;
import top.zhzhao.web.service.bus.BusUserService;

/**
 *
 *@author zhzhao
 *@version $ Id: BusUserServiceImpl.java,V 0.1 2018/1/22 15:49 zhzhao Exp $
 */
@Service
public class BusUserServiceImpl extends ServiceImpl<BusUserMapper,BusUser> implements
                                                                           BusUserService {
}
