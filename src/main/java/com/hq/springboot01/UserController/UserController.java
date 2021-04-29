package com.hq.springboot01.UserController;

import com.hq.springboot01.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    LeaveMapper leaveMapper;

    @RequestMapping("/login")
    public String userLogin(){
        return "login";
    }

    @RequestMapping("/main")
    public String toMain(){
        return "system";
    }


    @RequestMapping("/toLogin")
    public void toLogin(){
        System.out.println("1111");
    }

    @RequestMapping("/design")
    public String toDesign(HttpServletRequest request, HttpServletResponse response, HttpSession session, Authentication authentication){
        return "design";
    }

    @RequestMapping("/insert")
    public String toInsert(){
        return "insert";
    }

}
