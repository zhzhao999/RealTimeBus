/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.controller.bus;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusNightLine;
import top.zhzhao.web.model.bus.vo.BusTimeVO;
import top.zhzhao.web.model.bus.vo.LineDirVO;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.service.bus.BusNightLineService;
import top.zhzhao.web.service.bus.BusService;
import top.zhzhao.web.utils.Constants;
import top.zhzhao.web.utils.StringUtils;
import top.zhzhao.web.utils.response.ResponseVO;
import top.zhzhao.web.utils.response.ResponseVOUtils;

import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * 测试接口
     */
    @GetMapping(value = "test")
    public ResponseVO test(){
        return ResponseVOUtils.generateSuccess(Constants.Msg.SUCCESS);
    }

    /**
     * 获取所有车辆
     */
    @PostMapping(value = "findAll")
    public ResponseVO getAllBus(String type){
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
    public ResponseVO findListByName(String name,String type){
        if (StringUtils.isNotBlank(name)){
            if (StringUtils.isNotBlank(type) && type.equals("night")){
                EntityWrapper<BusNightLine> wrapper = new EntityWrapper<>();
                wrapper.eq("region_code", "bj");
                wrapper.like("line_name",name);
                List<BusNightLine> lineList = nightLineService.selectList(wrapper);
                return ResponseVOUtils.generateSuccess(lineList);
            }else {
                EntityWrapper<BusLine> wrapper = new EntityWrapper<>();
                wrapper.eq("region_code", "bj");
                wrapper.like("line_name",name);
                List<BusLine> lineList = lineService.selectList(wrapper);
                return ResponseVOUtils.generateSuccess(lineList);
            }
        }else {
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID 查询车辆 始发站和终点站
     * @param lineId  线路ID
     */
    @PostMapping(value = "getLineDir")
    public ResponseVO getLineDir(String lineId){
        if (StringUtils.isNotBlank(lineId)){
            List<LineDirVO> lineDir = busService.getLineDir(lineId);
            return ResponseVOUtils.generateSuccess(lineDir);
        }else{
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID和方向 查询车辆站点
     * @param lineId  线路ID
     * @param dirId  始发站方向ID
     */
    @PostMapping(value = "getDirStation")
    public ResponseVO getDirStation(String lineId,String dirId){
        if (StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(dirId)){
            List<LineDirVO> lineDir = busService.getDirStation(lineId,dirId);
            return ResponseVOUtils.generateSuccess(lineDir);
        }else{
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
    }

    /**
     * 根据 线路ID,方向ID,站点ID 查询实时信息
     * @param lineId  线路ID
     * @param dirId  始发站方向ID
     * @param stopId  站点ID
     */
    @PostMapping(value = "getBusTime")
    public ResponseVO getBusTime(String lineId,String dirId,String stopId){
        if (StringUtils.isNotBlank(lineId) && StringUtils.isNotBlank(dirId) && StringUtils.isNotBlank(stopId)){
            BusTimeVO busTime = busService.getBusTime(lineId,dirId,stopId);
            return ResponseVOUtils.generateSuccess(busTime);
        }else{
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
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
