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
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
