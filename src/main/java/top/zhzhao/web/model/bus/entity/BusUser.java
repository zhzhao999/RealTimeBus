/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import top.zhzhao.web.model.bus.entity.base.BusSuperEntity;

import java.util.Date;

/**
 * Bus-User实体
 *@author zhzhao
 *@version $ Id: BusUser.java,V 0.1 2018/1/16 14:48 zhzhao Exp $
 */
@SuppressWarnings("serial")
public class BusUser extends BusSuperEntity<BusUser> {

    /** 姓名 */
    private String name;
    /** 创建时间 */
    private Date  crtTime;
    /** 修改时间 */
    private Date  modTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }
}
