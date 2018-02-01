/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import top.zhzhao.web.model.bus.entity.base.BusBaseEntity;

import java.util.Date;

/**
 * Bus-User实体
 *@author zhzhao
 *@version $ Id: BusUser.java,V 0.1 2018/1/16 14:48 zhzhao Exp $
 */
@SuppressWarnings("serial")
public class BusUser extends BusBaseEntity<BusUser> {

    /** 微信用户唯一标识 */
    @JsonIgnore
    private String openid;
    /** 微信用户在开放平台的唯一标识符 */
    @JsonIgnore
    private String unionid;
    /** 微信会话密钥*/
    @JsonIgnore
    private String sessionKey;
    /** 微信昵称 */
    private String nickName;
    /** 微信头像 */
    private String avatarUrl;
    /** 性别 1:男 2:女 3:未知*/
    private String gender;
    /** 用户所在城市 */
    private String city;
    /** 用户所在省份 */
    private String province;
    /** 用户所在国家 */
    private String country;
    /** 用户的语言 zh_CN为简体中文 */
    private String language;
    /** 创建时间 */
    private Date  crtTime;
    /** 修改时间 */
    private Date  modTime;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
