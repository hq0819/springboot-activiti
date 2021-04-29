package com.hq.springboot01.userService;

import com.hq.springboot01.pojo.Leave;

import java.util.List;

public interface LeaveService {
    void insertLeave(Leave leave);
    List<Leave> queryLeave();
    Leave queryLeaveById(long leaveId);
    long getLeaveId();
}
