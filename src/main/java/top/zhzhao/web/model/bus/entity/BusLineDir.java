/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity;

import top.zhzhao.web.model.bus.entity.base.BusSuperEntity;

/**
 * 线路方向 实体
 *@author zhzhao
 *@version $ Id: BusLineDir.java,V 0.1 2018/2/9 14:03 zhzhao Exp $
 */
public class BusLineDir extends BusSuperEntity<BusLineDir> {

    private String lineId;
    private String dirId;
    private String negativeDirId;

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

    public String getNegativeDirId() {
        return negativeDirId;
    }

    public void setNegativeDirId(String negativeDirId) {
        this.negativeDirId = negativeDirId;
    }
}
