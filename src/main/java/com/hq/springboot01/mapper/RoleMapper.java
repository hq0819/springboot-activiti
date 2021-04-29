package com.hq.springboot01.mapper;

import com.hq.springboot01.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
   Role getRoleByUserName(String username);
}
