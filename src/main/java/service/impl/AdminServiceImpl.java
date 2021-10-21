package service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminService;

import mapper.*;
import utils.MD5Util;
import pojo.*;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/26 15:58
 */

@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层中,一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户或到DB中查询相应用户对象
        //如果有条件,则以定陶创建AdminExample的对象,用来封装条件
        AdminExample example=new AdminExample();

        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);
        List list=adminMapper.selectByExample(example);
        if(list.size()>0){
            Admin admin=(Admin)list.get(0);
            //如果查询到用户对象,再进行密码的对比,注意密码是密文
            String miPwd= MD5Util.getMD5(pwd);
            System.out.println(admin.getaPass());
            System.out.println(miPwd);
            if(miPwd.equals(admin.getaPass())){
                return admin;
            }
        }

        return null;

    }
}
