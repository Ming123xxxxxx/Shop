package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Admin;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/27 9:21
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
    //在所有界面层，一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    //实现登陆判断,并进行响应的跳转
    @RequestMapping("/login")
    public String login(String name,String pwd,HttpServletRequest servletRequest){

        Admin admin=adminService.login(name,pwd);
        if(admin!=null){
            //登陆成功
            servletRequest.setAttribute("admin",admin);
            return "main";
        }else{
            //登陆失败
            servletRequest.setAttribute("errmsg","用户名或密码不正确!");
            return "login";
        }

    }
}
