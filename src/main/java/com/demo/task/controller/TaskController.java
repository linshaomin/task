package com.demo.task.controller;

import com.demo.task.dto.TaskBatchUpdateDTO;
import com.demo.task.dto.TaskSaveDTO;
import com.demo.task.entity.Task;
import com.demo.task.service.TaskService;
import com.demo.task.utils.PageUtils;
import com.demo.task.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 任务相关controller
 *
 * @author  linsm
 * @date 2022/3/14 11:18 下午
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = taskService.queryPage(params);
        return R.ok().put("page", page);
    }

    @PostMapping("/save")
    public R save(TaskSaveDTO saveDto){
        saveDto.getSids().forEach(item->{
            Task task = new Task();
            BeanUtils.copyProperties(saveDto,task);
            task.setSid(item);
            taskService.save(task);
        });
        return R.ok();
    }

    @PostMapping("/update")
    public R update(Task task){
        taskService.updateById(task);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(String id){
        taskService.removeById(id);
        return R.ok();
    }

    @PostMapping("/batchUpdate")
    public R batchUpdate(TaskBatchUpdateDTO batchUpdateDTO){
        taskService.batchUpdate(batchUpdateDTO);
        return R.ok();
    }
}
