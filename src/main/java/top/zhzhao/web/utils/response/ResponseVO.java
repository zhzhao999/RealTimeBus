package top.zhzhao.web.utils.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 普通返回封装
 * @param <T> 具体实体对象
 */
public class ResponseVO<T> implements Serializable {

	private static final long serialVersionUID = 134474305226738346L;
	// 接口响应状态码
	private String repCode;
	// 接口调用返回信息
	private String repMsg;

	private T datas;

	public ResponseVO() {
	}

	public ResponseVO(String repCode, String repMsg) {
		this.repCode = repCode;
		this.repMsg = repMsg;
	}

	public ResponseVO(String repCode, String repMsg, List<Map<String, Object>> mapList) {
		super();
		this.repCode = repCode;
		this.repMsg = repMsg;
	}

	public String getRepCode() {
		return repCode;
	}

	public void setRepCode(String repCode) {
		this.repCode = repCode;
	}

	public String getRepMsg() {
		return repMsg;
	}

	public void setRepMsg(String repMsg) {
		this.repMsg = repMsg;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}
}
