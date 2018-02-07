/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhzhao.web.mapper.bus.BusCollectMapper;
import top.zhzhao.web.mapper.bus.BusLineMapper;
import top.zhzhao.web.model.bus.entity.BusCollect;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.vo.LineDirVO;
import top.zhzhao.web.service.bus.BusCollectService;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.service.bus.BusService;
import top.zhzhao.web.utils.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户收藏服务
 *@author zhzhao
 *@version $ Id: BusCollectServiceImpl.java,V 0.1 2018/1/27 18:09 zhzhao Exp $
 */
@Service
public class BusCollectServiceImpl extends ServiceImpl<BusCollectMapper,BusCollect>
        implements BusCollectService {

    @Autowired
    private BusService busService;

    @Override
    public boolean collect(String userId,String lineId, String dirId, String stopId) {
        BusCollect collect = new BusCollect();
        collect.setUserId(userId);
        collect.setLineId(lineId);
        collect.setDirId(dirId);
        collect.setStopId(stopId);
        collect.setCrtTime(new Date());
        //反方向ID
        List<LineDirVO> lineDir = busService.getLineDir(lineId);
        for (LineDirVO dirVo:lineDir) {
            String negativeDirId = dirVo.getValue();
            if (!negativeDirId.equals(dirId)){
                collect.setNegativeDirId(negativeDirId);
            }
        }
        //获取当前站点 和 下一站
        List<LineDirVO> dirStationList = busService.getDirStation(lineId, dirId);
        int currentId = Integer.parseInt(stopId);
        LineDirVO currentDirVO = dirStationList.get(currentId - 1);
        int negativeStopId = dirStationList.size()+1 - currentId;
        collect.setNegativeStopId(negativeStopId+"");
        collect.setCurrentStop(currentDirVO.getName());
        if (dirStationList.size() != currentId){
            LineDirVO nextDirVO = dirStationList.get(currentId);
            collect.setNextStop(nextDirVO.getName());
        }

        //保存数据
        return this.insert(collect);
    }
}
