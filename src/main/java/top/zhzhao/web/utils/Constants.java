package top.zhzhao.web.utils;
/**
 * 全局常量
 * @author zhzhao
 * @date 2017年11月3日
 */
public interface Constants {

	/**
	 * 用户状态
	 * @author zhzhao
	 */
	public interface UserStatus {
		String DIC_CODE = "USER_STAT";
		/**
		 * 启用
		 */
		String ENABLED = "USER_ENABLED";
		/**
		 * 停用
		 */
		String DISABLED = "USER_DISABLED";
		/**
		 * 过期
		 */
		String EXPIRED = "USER_EXPIRED";
		/**
		 * 离职(删除)
		 */
		String DIMISSION = "USER_DIMISSION";

	}

	/**
	 * 日志动作类型.
	 * @author zhzhao
	 */
	public interface ActionType {
		String LOGIN = "ACT_LOGIN";// 用户登录
	}

	/**
	 * 北京公交-数据接口地址
	 * @author zhzhao
	 */
	public interface BusUrl {
		String Line = "http://www.bjbus.com/home/fun_rtbus.php?uSec=00000160&uSub=00000162";// 普通公交数据
		String NightLine = "http://www.bjbus.com/home/fun_rtbus_nighttime.php?uSec=00000160&uSub=00000162";//夜班数据
		String Dir = "http://www.bjbus.com/home/ajax_rtbus_data.php";
	}

	public interface Msg {
		String ParamError = "参数不合法";
		String UpdateSuccess = "数据更新成功";
		String UpdateError = "数据更新失败";
	}
	
}
