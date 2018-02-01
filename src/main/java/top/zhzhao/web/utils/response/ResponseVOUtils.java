package top.zhzhao.web.utils.response;

/**
 * 生成ResponseVO对象的工具类
 * @author zhzhao
 */
public class ResponseVOUtils {
    /*返回编码由四位数字组成，前两位代表错误类型大类，后两位代码错误类型小类*/
    //成功编码
    public static final String CODE_0000 = "0000";
    //通用错误编码
    public static final String CODE_9999 = "9999";
    /*参数错误编码*/
    public static final String CODE_1000 = "1000";

    //禁止实例化
    private ResponseVOUtils() {
    }
    
    /**
     * 正确返回
     * 
     * @param datas 返回的数据
     * @return ResponseVO
     */
    public static <T> ResponseVO<T> generateSuccess(T datas) {
        ResponseVO<T> vo = new ResponseVO<T>(CODE_0000, null);
        vo.setDatas(datas);
        return vo;
    }

    /**
     * 正确返回-分页
     * 
     * @param datas 返回的分页数据
     * @return ResponseVO
     */
    public static <T> ResponseVO<T> generateSuccessPage(long totalCount, int pageSize, int currentPage, T datas) {
        ResponsePageVO<T> vo = new ResponsePageVO<T>(totalCount, pageSize, currentPage, null);
        vo.setRepCode(CODE_0000);
        vo.setDatas(datas);
        return vo;
    }

    /**
     * 生成参数错误返回VO
     * 
     * @param errMsg 错误信息
     * @return ResponseVO
     */
    public static <T> ResponseVO<T> generateParameterError(String errMsg) {
        ResponseVO<T> vo = new ResponseVO<T>(CODE_1000, errMsg);
        return vo;
    }

    /**
     * 通用的业务逻辑错误返回VO
     * 
     * @param : errMsg 错误信息
     * @return : ResponseVO
     */
    public static <T> ResponseVO<T> generateCommonError(String errMsg) {
        return new ResponseVO<T>(CODE_9999, errMsg);
    }
}
