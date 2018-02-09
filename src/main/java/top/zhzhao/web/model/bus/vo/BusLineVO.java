/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 *
 *@author zhzhao
 *@version $ Id: BusLineVO.java,V 0.1 2018/2/9 10:17 zhzhao Exp $
 */
public class BusLineVO {

    /** 线路名称 */
    private String lineName;
    /** 默认方向ID */
    private String defaultDirId;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getDefaultDirId() {
        return defaultDirId;
    }

    public void setDefaultDirId(String defaultDirId) {
        this.defaultDirId = defaultDirId;
    }
}
