package com.demo.task.dto;

import com.demo.task.entity.Task;
import lombok.Data;

import java.util.List;

/**
 *
 * 任务批量更新dto
 * @author  linsm
 * @date 2022/3/16 8:37 下午
 */
@Data
public class TaskBatchUpdateDTO extends Task {
    /**
     * ids
     */
    private List<Integer> ids;

    /**
     * 是否开启总评
     */
    private Integer isOpenComment;

    /**
     * 是否合格
     */
    private Integer isQualified;
}
