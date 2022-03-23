package com.demo.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.task.dto.TaskBatchUpdateDTO;
import com.demo.task.entity.Task;
import com.demo.task.utils.PageUtils;

import java.util.Map;

public interface TaskService extends IService<Task> {
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量更新
     *
     * @param
     * @return
     * @author linsm
     * @date 2022-03-18 20:52
     */
    void batchUpdate(TaskBatchUpdateDTO batchUpdateDTO);
}
