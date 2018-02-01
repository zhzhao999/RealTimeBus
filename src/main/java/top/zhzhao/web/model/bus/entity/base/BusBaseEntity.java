/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 *@author zhzhao
 *@version $ Id: BusBaseEntity.java,V 0.1 2018/1/26 17:05 zhzhao Exp $
 */
public class BusBaseEntity<T extends Model> extends BusSuperEntity {

    /** 数据状态 normal:正常 invalid:失效*/
    @JsonIgnore
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
