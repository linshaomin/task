package com.demo.task.controller;

import com.demo.task.entity.User;
import com.demo.task.service.UserService;
import com.demo.task.utils.PageUtils;
import com.demo.task.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户相关controller
 *
 * @author  linsm
 * @date 2022/3/14 9:56 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return R.ok().put("page", page);
    }

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return R.ok();
    }

    @GetMapping("/getById")
    public R getById(String id) {
        return R.ok(userService.getById(id));
    }

    @PostMapping("/delete")
    public R delete(String id){
        userService.removeById(id);
        return R.ok();
    }

    @GetMapping("/findAll")
    public R findAll(){
        return R.ok(userService.list());
    }
}
