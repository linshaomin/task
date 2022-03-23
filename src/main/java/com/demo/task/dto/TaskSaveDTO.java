package com.demo.task.dto;

import com.demo.task.entity.Task;
import lombok.Data;

import java.util.List;

/**
 *
 * 任务保存dto
 * @author  linsm
 * @date 2022/3/16 8:37 下午
 */
@Data
public class TaskSaveDTO extends Task {
    /**
     * 学生id集合
     */
    private List<Integer> sids;
}
