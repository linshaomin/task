package com.demo.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.task.entity.User;
import com.demo.task.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @功能描述: <pre></pre>
 * @Classname UserService
 * @Author: wanjiansheng@tansun.com.cn
 * @Date: 2022/3/10 11:18
 * @Version: 1.0
 */


public interface UserService extends IService<User> {

     User getLoginUser(String account, String password);

     List<User> listByRoleType(Integer roleType);

    PageUtils queryPage(Map<String, Object> params);
}
