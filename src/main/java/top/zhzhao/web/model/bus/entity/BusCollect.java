/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity;

import top.zhzhao.web.model.bus.entity.base.BusSuperEntity;

import java.util.Date;

/**
 * 收藏车辆 数据库实体
 *@author zhzhao
 *@version $ Id: BusCollect.java,V 0.1 2018/1/26 17:03 zhzhao Exp $
 */
public class BusCollect extends BusSuperEntity<BusCollect> {

    /** 用户实体 */
    private String userId;
    /** 线路的key */
    private String lineId;
    /** 方向ID */
    private String dirId;
    /** 站点ID */
    private String stopId;
    /** 反方向ID */
    private String negativeDirId;
    /** 站点名称 */
    private String currentStop;
    /** 下一站名称 */
    private String nextStop;
    /** 创建时间 */
    private Date   crtTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(String currentStop) {
        this.currentStop = currentStop;
    }

    public String getNegativeDirId() {
        return negativeDirId;
    }

    public void setNegativeDirId(String negativeDirId) {
        this.negativeDirId = negativeDirId;
    }

    public String getNextStop() {
        return nextStop;
    }

    public void setNextStop(String nextStop) {
        this.nextStop = nextStop;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}
