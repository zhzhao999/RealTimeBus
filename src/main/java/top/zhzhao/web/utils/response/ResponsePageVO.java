package top.zhzhao.web.utils.response;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;
import java.util.Map;

/**
 * 分页返回
 * @param <T> 具体实体
 */
public class ResponsePageVO<T> extends ResponseVO<T> {

	private static final long serialVersionUID = 5472321653620726832L;

	private final static int DEFAULT_NAVIGATOR_SIZE = 5;

	/* 当前页 */
	private int currentPage = 1;
	/* 每页显示数量 */
	private int pageSize = 5;
	/* 总记录数 */
	private long totalCount;
	/* 是否有下一页 */
	private boolean haveNextPage;
	/* 是否有上一页 */
	private boolean havePrePage;

	private int navigatorSize = DEFAULT_NAVIGATOR_SIZE;

	public ResponsePageVO() {

	}

	public ResponsePageVO(long totalCount, int pageSize, int currentPage, List<Map<String, Object>> mapList) {
		this(null, null, totalCount, pageSize, currentPage, mapList);
	}

	public ResponsePageVO(String repCode, String repMsg, long totalCount, int pageSize, int currentPage,
			List<Map<String, Object>> mapList) {
		super(repCode, repMsg, mapList);
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public ResponsePageVO(String repCode,String repMsg,
			long totalCount, int pageSize, int currentPage) {
		this(repCode,repMsg, totalCount, pageSize, currentPage, null);
	}

	public int getPageCount() {
		int pageCount = 0;
		if (pageSize != 0) {
			pageCount = (int) (totalCount / pageSize);
			if (totalCount % pageSize != 0)
				pageCount++;
		}
		return pageCount;
	}

	public int getCurrentPage() {
		currentPage = currentPage < getPageCount() ? currentPage : getPageCount();
		currentPage = currentPage < 1 ? 1 : currentPage;
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public boolean isHaveNextPage() {
		haveNextPage = false;
		if ((getPageCount() > 1) && (getPageCount() > getCurrentPage()))
			haveNextPage = true;
		return haveNextPage;
	}

	public boolean isHavePrePage() {
		havePrePage = false;
		if ((getPageCount() > 1) && (currentPage > 1))
			havePrePage = true;
		return havePrePage;
	}

	private int getNavigatorIndex(boolean isBegin) {
		int beginNavigatorIndex = getCurrentPage() - navigatorSize / 2;
		int endNavigatorIndex = getCurrentPage() + navigatorSize / 2;
		beginNavigatorIndex = beginNavigatorIndex < 1 ? 1 : beginNavigatorIndex;
		endNavigatorIndex = endNavigatorIndex < getPageCount() ? endNavigatorIndex : getPageCount();
		while ((endNavigatorIndex - beginNavigatorIndex) < navigatorSize
				&& (beginNavigatorIndex != 1 || endNavigatorIndex != getPageCount())) {
			if (beginNavigatorIndex > 1)
				beginNavigatorIndex--;
			else if (endNavigatorIndex < getPageCount())
				endNavigatorIndex++;
		}

		if (isBegin)
			return beginNavigatorIndex;
		else
			return endNavigatorIndex;
	}

	public int getBeginNavigatorIndex() {
		return getNavigatorIndex(true);
	}

	public int getEndNavigatorIndex() {
		return getNavigatorIndex(false);
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
