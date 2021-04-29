package com.hq.springboot01.userService.impl;

import com.hq.springboot01.mapper.LeaveMapper;
import com.hq.springboot01.pojo.Leave;
import com.hq.springboot01.userService.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LeaveService")
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveMapper leaveMapper;

    @Override
    public void insertLeave(Leave leave) {
        leaveMapper.insertLeave(leave);
    }

    @Override
    public List<Leave> queryLeave() {
        return leaveMapper.queryLeave();
    }

    @Override
    public Leave queryLeaveById(long leaveId) {
        return leaveMapper.queryLeaveById(leaveId);
    }

    @Override
    public long getLeaveId() {
        return leaveMapper.getLeaveId();
    }
}
