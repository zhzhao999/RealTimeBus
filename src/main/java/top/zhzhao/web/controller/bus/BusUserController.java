/**
 * https://www.zhzhao.top
 */
package top.zhzhao.web.controller.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhzhao.web.model.bus.entity.BusUser;
import top.zhzhao.web.service.bus.BusUserService;
import top.zhzhao.web.utils.response.ResponseVO;
import top.zhzhao.web.utils.response.ResponseVOUtils;

import java.util.Date;
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

    @GetMapping(value = "/getOne")
    public ResponseVO getUser(){
        BusUser user = userService.selectById(1);
        return ResponseVOUtils.generateSuccess(user);
    }

    @GetMapping(value = "/addOne")
    public ResponseVO addUser(){
        BusUser busUser = new BusUser();
        busUser.setName("Green");
        busUser.setCrtTime(new Date());
        boolean flag = userService.insert(busUser);
        if (flag){
            return ResponseVOUtils.generateSuccess("用户添加成功");
        }
        return ResponseVOUtils.generateCommonError("用户添加失败");
    }

    @GetMapping(value = "/getAll")
    public ResponseVO getUsers(){
        List<BusUser> list = userService.selectList(null);
        return ResponseVOUtils.generateSuccess(list);
    }
}
