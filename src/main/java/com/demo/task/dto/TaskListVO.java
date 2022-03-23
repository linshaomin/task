package com.demo.task.dto;

import com.demo.task.entity.Task;
import lombok.Data;

@Data
public class TaskListVO extends Task {
    /**
     * 指定学生名称
     */
    private String sname;
    /**
     * 指定老师名称
     */
    private String tname;
}
