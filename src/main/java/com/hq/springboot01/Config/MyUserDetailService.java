package com.hq.springboot01.Config;

import com.hq.springboot01.mapper.AuthenrizeMapper;
import com.hq.springboot01.mapper.RoleMapper;
import com.hq.springboot01.pojo.Authenrize;
import com.hq.springboot01.pojo.Role;
import com.hq.springboot01.pojo.User;
import com.hq.springboot01.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AuthenrizeMapper authenrizeMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser(s);
        if (user ==  null){
            throw new UsernameNotFoundException("用户名不存在！");

        }
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        Role role = roleMapper.getRoleByUserName(user.getUsername());
        long roleid = role.getRoleid();
        List<Authenrize> as = authenrizeMapper.getAuthenrizeByRoleId(roleid);

        list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        as.stream().forEach(authenrize ->list.add(new SimpleGrantedAuthority(authenrize.getAuthenrizeName())) );

        list.add(new SimpleGrantedAuthority("GROUP_"+user.getGroupName()));
        org.springframework.security.core.userdetails.User u
                = new org.springframework.security.core.userdetails.User(
               user.getUsername(),user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),user.isAccountNonLocked(),list);

        return u;
    }
}
