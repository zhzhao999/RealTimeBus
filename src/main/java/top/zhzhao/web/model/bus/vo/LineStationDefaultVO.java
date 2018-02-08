/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.model.bus.vo;

import java.util.List;

/**
 * 默认的站点ID实体
 *@author zhzhao
 *@version $ Id: LineStationDefaultVO.java,V 0.1 2018/2/8 9:40 zhzhao Exp $
 */
public class LineStationDefaultVO {
    private String          dirId; //当前方向id
    private String          dirName;//名称
    private String          negativeDirId;//反方向id
    private List<LineDirVO> stations;

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

    public List<LineDirVO> getStations() {
        return stations;
    }

    public void setStations(List<LineDirVO> stations) {
        this.stations = stations;
    }
}
