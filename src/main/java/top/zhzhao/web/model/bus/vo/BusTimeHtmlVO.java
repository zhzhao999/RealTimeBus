/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 从 公交网站 获取的 busTime实体
 *@author zhzhao
 *@version $ Id: BusTimeHtmlVO.java,V 0.1 2018/1/23 15:52 zhzhao Exp $
 */
public class BusTimeHtmlVO {
    private String html;
    private String seq;
    private String w;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }
}
