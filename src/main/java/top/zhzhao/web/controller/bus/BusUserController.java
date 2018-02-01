/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.controller.bus;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhzhao.web.model.bus.entity.BusUser;
import top.zhzhao.web.model.bus.vo.WeChatLoginVO;
import top.zhzhao.web.service.bus.BusUserService;
import top.zhzhao.web.utils.Constants;
import top.zhzhao.web.utils.HttpClientUtil;
import top.zhzhao.web.utils.StringUtils;
import top.zhzhao.web.utils.response.ResponseVO;
import top.zhzhao.web.utils.response.ResponseVOUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 用户
 *@author zhzhao
 *@version $ Id: BusUserController.java,V 0.1 2018/1/22 16:50 zhzhao Exp $
 */
@RestController
@RequestMapping(value = "/bus/user")
public class BusUserController {

    @Autowired
    private BusUserService userService;

    @PostMapping(value = "/login")
    public ResponseVO login(@RequestBody String code){
       if (StringUtils.isBlank(code)){
           return ResponseVOUtils.generateSuccess(Constants.Msg.ParamError);
       }
        HashMap<String, String> params = new HashMap<>();
        params.put("appid", Constants.WeChat.appId);
        params.put("secret",Constants.WeChat.appSecret);
        params.put("js_code",code);
        params.put("grant_type","authorization_code");
        String jsonStr = HttpClientUtil.doGet(Constants.WeChat.LoginUrl, params);
        Gson gson = new Gson();
        WeChatLoginVO loginVO = gson.fromJson(jsonStr, WeChatLoginVO.class);
        String openid = loginVO.getOpenid();
        BusUser user = userService
                .selectOne(new EntityWrapper<BusUser>().eq("openid", openid));
        if (user == null ){
            BusUser busUser = new BusUser();
            busUser.setOpenid(openid);
            busUser.setUnionid(loginVO.getUnionid());
            busUser.setSessionKey(loginVO.getSessionKey());
            busUser.setCrtTime(new Date());
            boolean flag = userService.insert(busUser);
            if (flag){
                user = userService.selectOne(new EntityWrapper<BusUser>().eq("openid", openid));
            }else {
               return ResponseVOUtils.generateCommonError(Constants.Msg.Error);
            }
        }
        return ResponseVOUtils.generateSuccess(user);
    }

    @PostMapping(value = "/update")
    public ResponseVO update(@RequestBody BusUser user){
        Long id = user.getId();
        if (id == null){
            return ResponseVOUtils.generateParameterError(Constants.Msg.ParamError);
        }
        user.setModTime(new Date());
        boolean flag = userService.updateById(user);
        if (!flag){
            return ResponseVOUtils.generateCommonError(Constants.Msg.UpdateError);
        }
        return ResponseVOUtils.generateSuccess(Constants.Msg.UpdateSuccess);
    }

}
