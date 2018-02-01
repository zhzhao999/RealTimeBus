/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.controller.bus;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhzhao.web.model.bus.entity.BusCollect;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusNightLine;
import top.zhzhao.web.model.bus.vo.*;
import top.zhzhao.web.service.bus.BusCollectService;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.service.bus.BusNightLineService;
import top.zhzhao.web.service.bus.BusService;
import top.zhzhao.web.utils.Constants;
import top.zhzhao.web.utils.StringUtils;
import top.zhzhao.web.utils.response.ResponseVO;
import top.zhzhao.web.utils.response.ResponseVOUtils;

import java.io.IOException;
import java.util.List;

/**
 * 实时公交
 *@author zhzhao
 *@version $ Id: BusController.java,V 0.1 2018/1/22 11:59 zhzhao Exp $
 */
@RestController
@RequestMapping(value = "/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private BusLineService lineService;

    @Autowired
    private BusNightLineService nightLineService;

    @Autowired
    private BusCollectService collectService;
    /**
     * 测试接口
     */
    @GetMapping(value = "test")
    public ResponseVO test(){
        return ResponseVOUtils.generateSuccess(Constants.Msg.Success);
    }

    /**
     * 获取所有车辆
     */
    @PostMapping(value = "findAll")
    public ResponseVO getAllBus(@RequestBody BusListCO listCO){
        String type = listCO.getType();
        if (StringUtils.isNotBlank(type) && type.equals("night")){
            List<BusNightLine> nightLines = nightLineService
                    .selectList(new EntityWrapper<BusNightLine>().eq("region_code", "bj"));
            return ResponseVOUtils.generateSuccess(nightLines);
        }else {
            List<BusLine> busLines = lineService
                    .selectList(new EntityWrapper<BusLine>().eq("region_code", "bj"));
            return ResponseVOUtils.generateSuccess(busLines);
        }
    }

    /**
     * 根据 车辆名称 查询 车辆列表
     */
    @PostMapping(value = "findListByName")
    public ResponseVO findListByName(@RequestBody BusListCO listCO){
        if (StringUtils.isNotBlank(listCO.getName())){
            if (StringUtils.isNotBlank(listCO.getType()) && listCO.getType().equals("night")){
                EntityWrapper<BusNightLine> wrapper = new EntityWrapper<>();
                wrapper.eq("region_code", "bj");
                wrapper.like("line_name",listCO.getName());
                List<BusNightLine> lineList = nightLineService.selectList(wrapper);
                return ResponseVOUtils.generateSuccess(lineList);
            }else {
                EntityWrapper<BusLine> wrapper = new EntityWrapper<>();
                wrapper.eq("region_code", "bj");
                wrapper.like("line_name",listCO.getName());
                List<BusLine> lineList = lineService.selectList(wrapper);
                return ResponseVOUtils.generateSuccess(lineList);
            }
        }else {
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID 查询车辆 始发站和终点站
     */
    @PostMapping(value = "getLineDir")
    public ResponseVO getLineDir(@RequestBody BusTimeCO timeCO){
        String lineId = timeCO.getLineId();
        if (StringUtils.isNotBlank(lineId)){
            List<LineDirVO> lineDir = busService.getLineDir(lineId);
            return ResponseVOUtils.generateSuccess(lineDir);
        }else{
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID和方向 查询车辆站点
     */
    @PostMapping(value = "getDirStation")
    public ResponseVO getDirStation(@RequestBody BusTimeCO timeCO){
        String lineId = timeCO.getLineId();
        String dirId = timeCO.getDirId();
        if (StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(dirId)){
            List<LineDirVO> lineDir = busService.getDirStation(lineId,dirId);
            return ResponseVOUtils.generateSuccess(lineDir);
        }else{
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID,方向ID,站点ID 查询实时信息
     */
    @PostMapping(value = "getBusTime")
    public ResponseVO getBusTime(@RequestBody BusTimeCO timeCO){
        String lineId = timeCO.getLineId();
        String dirId = timeCO.getDirId();
        String stopId = timeCO.getStopId();
        try {
            if (StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(dirId) && StringUtils.isNotBlank(stopId)){
                BusTimeVO busTime = busService.getBusTime(lineId,dirId,stopId);
                return ResponseVOUtils.generateSuccess(busTime);
            }else{
                return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVOUtils.generateParameterError(Constants.Msg.Error);
        }
    }

    /**
     * 获取用户收藏列表
     * @param userId 用户ID
     */
    @PostMapping(value = "getCollectList")
    public ResponseVO getCollectList(@RequestBody String userId){
        if (StringUtils.isBlank(userId)){
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
        List<BusCollect> collectList = collectService
                .selectList(new EntityWrapper<BusCollect>().eq("user_id", userId));
        return ResponseVOUtils.generateSuccess(collectList);
    }

    @PostMapping(value = "collect")
    public ResponseVO collect(@RequestBody BusCollectCO collectCO){
        String userId = collectCO.getUserId();
        String lineId = collectCO.getLineId();
        String dirId = collectCO.getDirId();
        String stopId = collectCO.getStopId();
        try {
            if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(dirId) && StringUtils.isNotBlank(stopId)){
                BusCollect collect = collectService.collect(userId,lineId,dirId,stopId);
                return ResponseVOUtils.generateSuccess(collect);
            }else{
                return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVOUtils.generateParameterError(Constants.Msg.Error);
        }
    }

    @PostMapping(value = "cancelCollect")
    public ResponseVO cancelCollect(@RequestBody String collectId){
        if (StringUtils.isBlank(collectId)){
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
        boolean flag = collectService.deleteById(collectId);
        if (flag){
            return ResponseVOUtils.generateSuccess(Constants.Msg.Success);
        }
        return ResponseVOUtils.generateCommonError(Constants.Msg.Error);
    }


    /**
     * 更新 白班 数据
     */
    @GetMapping("/updateLine")
    public ResponseVO updateLine(){
        try {
            lineService.updateLine();
            return ResponseVOUtils.generateSuccess(Constants.Msg.UpdateSuccess);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseVOUtils.generateCommonError(Constants.Msg.UpdateError);
        }
    }

    /**
     * 更新 夜班 数据
     */
    @GetMapping("/updateNightLine")
    public ResponseVO updateNightLine(){
        try {
            nightLineService.updateNightLine();
            return ResponseVOUtils.generateSuccess(Constants.Msg.UpdateSuccess);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseVOUtils.generateCommonError(Constants.Msg.UpdateError);
        }
    }
}
