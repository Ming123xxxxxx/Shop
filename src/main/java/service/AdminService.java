package service;

import pojo.*;
/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/26 15:55
 */
public interface AdminService {
    //完成登陆判断
    Admin  login(String name,String pwd);
}
