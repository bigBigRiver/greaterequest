package com.river.web.function.smartrequst.serivce;

import com.river.web.function.smartrequst.model.User;

/**
 * @Author river66
 * @Date 2021/1/1 21:22
 */
public interface UserSerivce {
    User getUserByName(String userName);

    String dealUserInfo(String userName, String password, Integer age);
}
