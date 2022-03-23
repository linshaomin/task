package com.demo.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.task.dao.TaskMapper;
import com.demo.task.dto.TaskBatchUpdateDTO;
import com.demo.task.dto.TaskListVO;
import com.demo.task.entity.Task;
import com.demo.task.entity.User;
import com.demo.task.service.TaskService;
import com.demo.task.service.UserService;
import com.demo.task.utils.PageUtils;
import com.demo.task.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //根据账号权限显示
        User u = (User)request.getSession().getAttribute("user");
        QueryWrapper<Task> queryWrapper = new QueryWrapper();
        if(u != null && u.getRoleType()==2) {
            queryWrapper.eq("tid",u.getId());
        } else if(u != null && u.getRoleType()==3) {
            queryWrapper.eq("sid",u.getId());
        }
        IPage<Task> page = this.page(
                new Query<Task>().getPage(params),
                queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<Task> data = (List<Task>) pageUtils.getList();
        List<Integer> tids = data.stream().map(Task::getTid).collect(Collectors.toList());
        List<Integer> sids = data.stream().map(Task::getSid).collect(Collectors.toList());
        tids.addAll(sids);
        Map<Integer,String> map = new HashMap<>();
        if(!CollectionUtils.isEmpty(tids)) {
            List<User> users = userService.listByIds(tids);
            map = users.stream().collect(Collectors.toMap(User::getId,User::getName));
        }
        List<TaskListVO> list = new ArrayList<>();
        for(Task task : data) {
            TaskListVO taskListVO = new TaskListVO();
            BeanUtils.copyProperties(task,taskListVO);
            taskListVO.setSname(map.get(taskListVO.getSid()));
            taskListVO.setTname(map.get(taskListVO.getTid()));
            list.add(taskListVO);
        }
        pageUtils.setList(list);
        return pageUtils;
    }

    @Override
    public void batchUpdate(TaskBatchUpdateDTO batchUpdateDTO) {
        this.lambdaUpdate()
                .set(batchUpdateDTO.getScore() != null,Task::getScore,batchUpdateDTO.getScore())
                .set(batchUpdateDTO.getIsOpenComment() != null,Task::getIsOpenComment,batchUpdateDTO.getIsOpenComment())
                .set(batchUpdateDTO.getIsQualified() != null,Task::getIsQualified,batchUpdateDTO.getIsQualified())
                .in(!CollectionUtils.isEmpty(batchUpdateDTO.getIds()),Task::getId,batchUpdateDTO.getIds())
                .update();
    }

}
