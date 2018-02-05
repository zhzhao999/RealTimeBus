package top.zhzhao.web.utils;
/**
 * 全局常量
 * @author zhzhao
 * @date 2017年11月3日
 */
public interface Constants {

	/**
	 * 北京公交-数据接口地址
	 * @author zhzhao
	 */
	public interface BusUrl {
		String Line = "http://www.bjbus.com/home/fun_rtbus.php?uSec=00000160&uSub=00000162";// 普通公交数据
		String NightLine = "http://www.bjbus.com/home/fun_rtbus_nighttime.php?uSec=00000160&uSub=00000162";//夜班数据
		String Dir = "http://www.bjbus.com/home/ajax_rtbus_data.php";
	}

	/**
	 * 微信相关
	 * @author zhzhao
	 */
	public interface WeChat{
		String appId = "wx45b001a66bab8445";
		String appSecret = "8546fb452ca867f02aef196141015dd4";
		String LoginUrl = "https://api.weixin.qq.com/sns/jscode2session";

		String errmsg = "code无效";
	}

	/**
	 * 提示信息
	 * @author zhzhao
	 */
	public interface Msg {
		String LoginSuccess  = "登录成功";
		String LoginError    = "登录失败，请稍后再试";
		String Success       = "请求成功";
		String Error         = "服务器走丢了，请稍后再试";
		String ParamError    = "参数不合法";
		String UpdateSuccess = "数据更新成功";
		String UpdateError   = "数据更新失败";
	}
	
}
