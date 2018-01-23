/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 线路方向
 *@author zhzhao
 *@version $ Id: LineDirVO.java,V 0.1 2018/1/23 14:24 zhzhao Exp $
 */
public class LineDirVO {

    public LineDirVO() {
    }

    public LineDirVO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
