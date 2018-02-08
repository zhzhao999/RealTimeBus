/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

/**
 * 方向VO
 *@author zhzhao
 *@version $ Id: LineDefaultDirVO.java,V 0.1 2018/2/8 15:05 zhzhao Exp $
 */
public class LineDefaultDirVO {
    private String          dirId; //当前方向id
    private String          dirName;//名称
    private String          negativeDirId;//反方向id
    private String          negativeDirName;//反名称

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getNegativeDirId() {
        return negativeDirId;
    }

    public void setNegativeDirId(String negativeDirId) {
        this.negativeDirId = negativeDirId;
    }

    public String getNegativeDirName() {
        return negativeDirName;
    }

    public void setNegativeDirName(String negativeDirName) {
        this.negativeDirName = negativeDirName;
    }
}
