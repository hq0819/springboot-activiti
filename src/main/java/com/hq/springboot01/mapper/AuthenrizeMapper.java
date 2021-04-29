package com.hq.springboot01.mapper;

import com.hq.springboot01.pojo.Authenrize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthenrizeMapper {
   List<Authenrize> getAuthenrizeByRoleId(long roleId);
}
