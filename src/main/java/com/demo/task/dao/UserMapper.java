package com.demo.task.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.task.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @功能描述: <pre></pre>
 * @Classname UserMapper
 * @Author: wanjiansheng@tansun.com.cn
 * @Date: 2022/3/10 11:15
 * @Version: 1.0
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

}
