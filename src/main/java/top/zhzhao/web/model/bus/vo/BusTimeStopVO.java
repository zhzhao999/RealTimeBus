/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 实时到站信息的  站点对象
 *@author zhzhao
 *@version $ Id: BusTimeStopVO.java,V 0.1 2018/1/24 9:35 zhzhao Exp $
 */
public class BusTimeStopVO {

    /** 站点名称 */
    private String stopName;
    /** 是否有途中车辆 */
    private boolean isArriving;
    /** 是否有到站车辆 */
    private boolean isArrived;

    public BusTimeStopVO() {
    }

    public BusTimeStopVO(String stopName) {
        this.stopName = stopName;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public boolean isArriving() {
        return isArriving;
    }

    public void setArriving(boolean arriving) {
        isArriving = arriving;
    }

    public boolean isArrived() {
        return isArrived;
    }

    public void setArrived(boolean arrived) {
        isArrived = arrived;
    }
}
