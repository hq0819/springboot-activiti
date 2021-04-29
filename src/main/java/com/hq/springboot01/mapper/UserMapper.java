package com.hq.springboot01.mapper;

import com.hq.springboot01.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(String username);


}
