package com.hq.springboot01.mapper;

import com.hq.springboot01.pojo.Leave;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LeaveMapper {
    void insertLeave(Leave leave);
    List<Leave> queryLeave();
    Leave queryLeaveById(long leaveId);
    long getLeaveId();

}
