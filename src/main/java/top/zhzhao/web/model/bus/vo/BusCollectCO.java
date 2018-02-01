/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

import top.zhzhao.web.model.bus.entity.BusCollect;

/**
 * 收藏
 *@author zhzhao
 *@version $ Id: BusCollectCO.java,V 0.1 2018/2/1 14:59 zhzhao Exp $
 */
public class BusCollectCO extends BusTimeCO{

    /** 用户ID */
    private String userId;
    /** 收藏ID */
    private String collectId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }
}
