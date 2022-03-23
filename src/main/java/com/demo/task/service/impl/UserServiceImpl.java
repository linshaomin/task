package com.demo.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.task.dao.UserMapper;
import com.demo.task.entity.User;
import com.demo.task.service.UserService;
import com.demo.task.utils.PageUtils;
import com.demo.task.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户service实现类
 *
 * @author  linsm
 * @date 2022/3/14 8:11 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getLoginUser(String account, String password) {
        User existsUser = this.lambdaQuery()
                .eq(User::getAccount,account)
                .eq(User::getPassword,password).one();
        return existsUser;
    }

    @Override
    public List<User> listByRoleType(Integer roleType) {
        return this.lambdaQuery().eq(User::getRoleType,roleType).list();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<User> page = this.page(
                new Query<User>().getPage(params),
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }
}
