/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import top.zhzhao.web.mapper.bus.BusLineMapper;
import top.zhzhao.web.mapper.bus.BusNightLineMapper;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.model.bus.entity.BusNightLine;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.service.bus.BusNightLineService;
import top.zhzhao.web.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *@author zhzhao
 *@version $ Id: BusNightLineServiceImpl.java,V 0.1 2018/1/23 11:18 zhzhao Exp $
 */
@Service
public class BusNightLineServiceImpl extends ServiceImpl<BusNightLineMapper,BusNightLine>
        implements BusNightLineService {

    @Override
    public void updateNightLine() throws IOException {
        Document doc = Jsoup.connect(Constants.BusUrl.NightLine).get();
        Element element = doc.getElementById("selLine");
        org.jsoup.select.Elements option = element.select("option");
        Iterator<Element> iterator = option.iterator();
        ArrayList<BusNightLine> list = new ArrayList<>();
        BusNightLine busLine = null;
        while(iterator.hasNext()) {
            Element ele = (Element)iterator.next();
            String  text = ele.text();
            String val = ele.val();
            busLine = new BusNightLine(val,text,"bj");
            list.add(busLine);
        }
        //将 数据库中不存在的数据 存入数据库
        if (list.size() > 0){
            //先清空原始数据,在删除  再添加
            this.delete(new EntityWrapper<BusNightLine>().eq("region_code", "bj"));
            this.insertBatch(list);
        }
    }
}
