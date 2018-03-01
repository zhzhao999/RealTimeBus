/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhzhao.web.mapper.bus.BusLineDirMapper;
import top.zhzhao.web.model.bus.entity.BusLineDir;
import top.zhzhao.web.service.bus.BusLineDirService;

/**
 *
 *@author zhzhao
 *@version $ Id: BusLineDirServiceImpl.java,V 0.1 2018/2/9 14:21 zhzhao Exp $
 */
@Service
public class BusLineDirServiceImpl extends ServiceImpl<BusLineDirMapper,BusLineDir> implements BusLineDirService {

    @Override
    public void truncate() {
        this.baseMapper.truncate();
    }

    @Override
    public String findDefDirByName(String lineName) {
        String dirId = this.baseMapper.findDefDirByName(lineName);
        return dirId;
    }
}
