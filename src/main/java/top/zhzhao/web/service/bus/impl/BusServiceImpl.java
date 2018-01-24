/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.service.bus.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import top.zhzhao.web.model.bus.vo.BusTimeHtmlVO;
import top.zhzhao.web.model.bus.vo.BusTimeStopVO;
import top.zhzhao.web.model.bus.vo.BusTimeVO;
import top.zhzhao.web.model.bus.vo.LineDirVO;
import top.zhzhao.web.service.bus.BusService;
import top.zhzhao.web.utils.Constants;
import top.zhzhao.web.utils.HttpClientUtil;
import top.zhzhao.web.utils.StringUtils;

import java.util.*;

/**
 *
 *@author zhzhao
 *@version $ Id: BusServiceImpl.java,V 0.1 2018/1/23 14:08 zhzhao Exp $
 */
@Service
public class BusServiceImpl implements BusService {

    @Override
    public List<LineDirVO> getLineDir(String id) {
        //  http://www.bjbus.com/home/ajax_rtbus_data.php?act=getLineDirOption&selBLine=10
        HashMap<String, String> params = new HashMap<>();
        params.put("act","getLineDirOption");
        params.put("selBLine",id);
        return this.getValue(params);
    }

    @Override
    public List<LineDirVO> getDirStation(String lineId, String dirId) {
        //  http://www.bjbus.com/home/ajax_rtbus_data.php?act=getDirStationOption&selBLine=10&selBDir=5192287798525865037
        HashMap<String, String> params = new HashMap<>();
        params.put("act","getDirStationOption");
        params.put("selBLine",lineId);
        params.put("selBDir",dirId);
        return this.getValue(params);
    }

    @Override
    public BusTimeVO getBusTime(String lineId, String dirId, String stopId) {
        // http://www.bjbus.com/home/ajax_rtbus_data.php?act=busTime&selBLine=10&selBDir=5192287798525865037&selBStop=6
        HashMap<String, String> params = new HashMap<>();
        params.put("act","busTime");
        params.put("selBLine",lineId);
        params.put("selBDir",dirId);
        params.put("selBStop",stopId);
        String jsonStr = HttpClientUtil.doGet(Constants.BusUrl.Dir, params);
        Gson gson = new Gson();
        BusTimeHtmlVO htmlVO = gson.fromJson(jsonStr, BusTimeHtmlVO.class);
        String html = htmlVO.getHtml();
        Document document = Jsoup.parse(html);

        //获取提示信息
        Elements elements = document.getElementsByClass("inner");
        Elements article = elements.get(0).select("article");
        Elements p = article.get(0).select("p");
        Iterator<Element> iterator = p.iterator();
        BusTimeVO busTimeVO = new BusTimeVO();
        int i = 0;
        while (iterator.hasNext()){
            Element ele = iterator.next();
            String text = ele.text();
            if (i == 0){
                String[] split = StringUtils.split(text.trim(), " ");
                busTimeVO.setCurrentStop(split[0]);
                busTimeVO.setOperationTime(split[1]);
                busTimeVO.setPriceType(split[2]);
                if (split.length > 4){
                    busTimeVO.setBranchCompany(split[4]);
                }
            }else{
                String[] split = StringUtils.split(text.trim(), " ");
                busTimeVO.setLastStop(split[1]);
                String[] instance = StringUtils.split(split[4], "，");
                busTimeVO.setLastDistance(split[3]+instance[0]);
                busTimeVO.setExpectedTime(split[5]+split[6]);
            }
            i++;
//            System.out.println(text);
        }

        //获取站点信息
        Elements stopEles = document.getElementsByClass("inquiry_main");
        Elements ul = stopEles.get(0).select("ul");
        Elements span = ul.get(0).select("span");
        Iterator<Element> iter = span.iterator();
        ArrayList<BusTimeStopVO> stopList = new ArrayList<>();
        BusTimeStopVO stopVO = null;
        while (iter.hasNext()){
            Element next = iter.next();
            stopVO = new BusTimeStopVO(next.text());
            stopList.add(stopVO);
        }
        //获取到站信息
        Elements buscE = ul.get(0).getElementsByClass("busc");
        Iterator<Element> ito = buscE.iterator();
        while (ito.hasNext()){
            Element ele = ito.next();
            Element parent = ele.parent();
            String idStr = parent.id();
            String id = StringUtils.substring(idStr, 0, idStr.length() - 1);
            stopList.get(Integer.parseInt(id)-1).setArrived(true);
        }
        //获取即将到站信息
        Elements bussE = ul.get(0).getElementsByClass("buss");
        Iterator<Element> it = bussE.iterator();
        while (it.hasNext()){
            Element ele = it.next();
            Element parent = ele.parent();
            String id = parent.id();
            stopList.get(Integer.parseInt(id)-1).setArriving(true);
        }
        busTimeVO.setStopList(stopList);
        return busTimeVO;
    }

    public List<LineDirVO> getValue(HashMap params){
        String html = HttpClientUtil.doGet(Constants.BusUrl.Dir, params);
        Document document = Jsoup.parse(html);
        Elements elements = document.getAllElements();
        Elements optionList = elements.get(0).select("option");
        Iterator<Element> iterator = optionList.iterator();
        ArrayList<LineDirVO> lineDirList = new ArrayList<>();
        LineDirVO lineDirVO = null;
        while (iterator.hasNext()){
            Element element = iterator.next();
            String text = element.text();
            String val = element.val();
            if (StringUtils.isNotBlank(val)){
                lineDirVO = new LineDirVO(text,val);
                lineDirList.add(lineDirVO);
            }
        }
        return lineDirList;
    }
}
