/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import top.zhzhao.web.model.bus.entity.base.BusSuperEntity;

import java.io.Serializable;

/**
 *
 *@author zhzhao
 *@version $ Id: BusNightLine.java,V 0.1 2018/1/22 19:37 zhzhao Exp $
 */
public class BusNightLine extends Model<BusLine> {

    public BusNightLine() {

    }
    public BusNightLine(String lineKey, String lineName,String regionCode) {
        this.lineKey = lineKey;
        this.lineName = lineName;
        this.regionCode = regionCode;
    }

    /** 主键ID */
    @JsonIgnore
    private Long id;
    /** 数据状态 normal:正常 invalid:失效*/
    @JsonIgnore
    private String state;
    /** 线路查询的key */
    private String lineKey;
    /** 线路名称 */
    private String lineName;
    /** 地区编码 */
    private String regionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLineKey() {
        return lineKey;
    }

    public void setLineKey(String lineKey) {
        this.lineKey = lineKey;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
