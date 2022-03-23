package com.demo.task.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("task")
public class Task extends BaseEntity {

    /**
     * 名称
     */
    private String name;

    /**
     * 占比
     */
    private Integer ratio;

    /**
     * 是否完成
     */
    private Integer isFinish;

    /**
     * 是否开启总评
     */
    private Integer isOpenComment;

    /**
     * 是否合格
     */
    private Integer isQualified;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 指定老师id
     */
    private Integer tid;

    /**
     * 分数
     */
    private Integer score;

}
