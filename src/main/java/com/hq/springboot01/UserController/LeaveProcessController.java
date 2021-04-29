package com.hq.springboot01.UserController;


import com.hq.springboot01.pojo.Leave;
import com.hq.springboot01.userService.LeaveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveProcessController {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    LeaveService leaveService;

    @RequestMapping("/startLeave")
    public String startLeave(Leave leave, Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long leaveId = leaveService.getLeaveId();
        leave.setLeaveTime(timestamp);
        leave.setLeaveName(principal.getUsername());
        leave.setLeaveId(leaveId);
        Map<String,Object> vars = new HashMap<>();
        vars.put(leaveId+":Leave",leave);
        vars.put("username",principal.getUsername());
        ProcessInstance leave1 = runtimeService.startProcessInstanceByKey("leave", vars);

        Task task = taskService.createTaskQuery().processInstanceId(leave1.getId()).singleResult();
        if (task != null){
            taskService.complete(task.getId(),vars);
        }
        return "design";
    }


    @RequestMapping("/getTask")
    public String getTask(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        List<Task> list = taskService.createTaskQuery().processDefinitionKey("leave").list();
        return "design";
    }
}
