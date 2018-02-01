/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

/**
 * 给前端的 实时公交对象
 *@author zhzhao
 *@version $ Id: BusTimeVO.java,V 0.1 2018/1/23 15:51 zhzhao Exp $
 */
public class BusTimeVO {
    /** 当前站点 */
    private String              currentStop;
    /** 运营时间 */
    private String              operationTime;
    /** 计价方式 */
    private String              priceType;
    /** 分公司名称 */
    @JsonIgnore
    private String              branchCompany;
    /** 最近还有几站 */
    private String              lastStop;
    /** 最近距离 公里 */
    private String              lastDistance;
    /** 预计到达时间 */
    private String              expectedTime;
    /** 有时候 返回数据无规律, 这时会用该信息代替 几站 几公里 到达时间 */
    private String              otherMsg;
    /** 站点集合 */
    private List<BusTimeStopVO> stopList;

    public String getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(String currentStop) {
        this.currentStop = currentStop;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany;
    }

    public String getLastStop() {
        return lastStop;
    }

    public void setLastStop(String lastStop) {
        this.lastStop = lastStop;
    }

    public String getLastDistance() {
        return lastDistance;
    }

    public void setLastDistance(String lastDistance) {
        this.lastDistance = lastDistance;
    }

    public String getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
    }

    public List<BusTimeStopVO> getStopList() {
        return stopList;
    }

    public void setStopList(List<BusTimeStopVO> stopList) {
        this.stopList = stopList;
    }

    public String getOtherMsg() {
        return otherMsg;
    }

    public void setOtherMsg(String otherMsg) {
        this.otherMsg = otherMsg;
    }
}
