/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 微信用户登录后返回实体
 *@author zhzhao
 *@version $ Id: WeChatLoginVO.java,V 0.1 2018/1/31 18:15 zhzhao Exp $
 */
public class WeChatLoginVO {
    private String openid;
    private String sessionKey;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

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
}
