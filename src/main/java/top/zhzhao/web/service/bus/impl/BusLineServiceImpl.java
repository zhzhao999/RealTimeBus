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
import org.springframework.transaction.annotation.Transactional;
import top.zhzhao.web.mapper.bus.BusLineMapper;
import top.zhzhao.web.model.bus.entity.BusLine;
import top.zhzhao.web.service.bus.BusLineService;
import top.zhzhao.web.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *@author zhzhao
 *@version $ Id: BusBjLineServiceImpl.java,V 0.1 2018/1/22 20:06 zhzhao Exp $
 */
@Service
public class BusLineServiceImpl extends ServiceImpl<BusLineMapper,BusLine>
        implements BusLineService {

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
}
