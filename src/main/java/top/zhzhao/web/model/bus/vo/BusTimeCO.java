/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 查询实时车辆 入参
 *@author zhzhao
 *@version $ Id: BusTimeCO.java,V 0.1 2018/1/25 17:11 zhzhao Exp $
 */
public class BusTimeCO {
    /** 线路ID */
    private String lineId;
    /** 方向ID */
    private String dirId;
    /** 站点ID */
    private String stopId;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }
}
