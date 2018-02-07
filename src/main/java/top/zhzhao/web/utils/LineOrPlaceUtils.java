/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 线路或者地点 判断
 *@author zhzhao
 *@version $ Id: LineOrPlaceUtils.java,V 0.1 2018/2/7 15:51 zhzhao Exp $
 */
public class LineOrPlaceUtils {

    private static String[] lines = {"有轨电车西郊线","燕郊专线","莲花桥临线","通勤东湖港","通勤向阳","通勤柴厂屯",
                                     "通勤海子角","通勤礼贤","通勤苹果园","通勤香汐","金安桥临线"};

    /**
     * 判断是否为线路
     * @param content 输入的内容
     * @return 线路:true  非线路:false
     */
    public static boolean isLine(String content) {
        Pattern p = Pattern.compile(".*\\d+.*");// 判断一个字符串是否含有数字
        Matcher m = p.matcher(content);
        if (m.matches()) {
            return true;
        }else {
            return ArrayUtils.contains(lines, content);
        }
    }
}
