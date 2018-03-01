/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhzhao.web.mapper.bus.BusLineMapper;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusLineDir;
import top.zhzhao.web.model.bus.vo.LineDirVO;
import top.zhzhao.web.service.bus.BusLineDirService;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.service.bus.BusService;
import top.zhzhao.web.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 *@author zhzhao
 *@version $ Id: BusBjLineServiceImpl.java,V 0.1 2018/1/22 20:06 zhzhao Exp $
 */
@Service
public class BusLineServiceImpl extends ServiceImpl<BusLineMapper,BusLine>
        implements BusLineService {

    @Autowired
    private BusService busService;
    @Autowired
    private BusLineDirService lineDirService;

    @Override
    @Transactional
    public void updateLine() throws IOException {
        //从HTML中获取 车辆信息
        Document doc = Jsoup.connect(Constants.BusUrl.Line).get();
        Element element = doc.getElementById("selBLine");
        org.jsoup.select.Elements option = element.select("a");
        Iterator<Element> iterator = option.iterator();
        ArrayList<BusLine> list = new ArrayList<>();
        BusLine busLine = null;
        while(iterator.hasNext()) {
            Element ele = (Element)iterator.next();
            String  text = ele.text();
            busLine = new BusLine(text,text,"bj");
            list.add(busLine);
        }
        //将 数据库中不存在的数据 存入数据库
        if (list.size() > 0){
            //先清空原始数据,在删除  再添加
            this.delete(new EntityWrapper<BusLine>().eq("region_code", "bj"));
            this.insertBatch(list);
        }

    }

    @Override
    @Transactional
    public void updateDir() throws IOException {
        List<BusLine> busLines = this
                .selectList(new EntityWrapper<BusLine>().eq("region_code", "bj"));
        ArrayList<BusLineDir> lineDirList = new ArrayList<>();
        BusLineDir lineDir = null;
        for (BusLine line:busLines) {
            Long lineId = line.getId();
            String lineName = line.getLineName();
            List<LineDirVO> lineDirVOList = busService.getLineDir(lineName);
            String dirId = null;
            String negativeDirId = null;
            for (int i = 0;i<lineDirVOList.size();i++){
                String id = lineDirVOList.get(i).getValue();
                if (i == 0){
                    dirId = id;
                }else {
                    negativeDirId = id;
                }
            }
            lineDir = new BusLineDir();
            lineDir.setDirId(dirId);
            lineDir.setLineId(lineId+"");
            lineDir.setNegativeDirId(negativeDirId);
            lineDirList.add(lineDir);
        }

        if (lineDirList != null && lineDirList.size() > 0){
            //清空原始数据
            lineDirService.truncate();
            lineDirService.insertBatch(lineDirList);
        }


    }
}
