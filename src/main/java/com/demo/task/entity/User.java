package com.demo.task.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User extends BaseEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 编号
     */
    private String no;

    /**
     * 名称
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 所属角色（0-管理员，1-老师，2-学生）
     */
    private Integer roleType;

}
