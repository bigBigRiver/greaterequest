package com.river.web.function.smartrequst.serivce.impl;

import com.river.web.function.smartrequst.model.User;
import com.river.web.function.smartrequst.serivce.UserSerivce;
import org.springframework.stereotype.Service;

/**
 * @Author river66
 * @Date 2021/1/1 21:25
 */
@Service
public class UserServiceImpl implements UserSerivce {

    @Override
    public User getUserByName(String userName) {
        if (null != userName && userName.equals("river")) {
            return new User("river66", "惠州市惠阳区");
        }
        return null;
    }

    @Override
    public String dealUserInfo(String userName, String password, Integer age) {
        return "delUserInfo(" + userName + ":" + password + ":" + age + ") success, return!";
    }
}
