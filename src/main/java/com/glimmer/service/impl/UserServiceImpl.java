package com.glimmer.service.impl;

import com.glimmer.constant.MessageConstant;
import com.glimmer.dto.LoginDto;
import com.glimmer.exception.BaseException;
import com.glimmer.mapper.UserMapper;
import com.glimmer.model.User;
import com.glimmer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginDto userLoginDTO) {
        String name = userLoginDTO.getName();
        String passwd = userLoginDTO.getPasswd();

        //根据用户名查询数据库中的数据
        User user = userMapper.getByName(name);

        if (user == null) {
            //账号不存在
            throw new BaseException(MessageConstant.ACCOUNT_NOT_FOUND);

        }
        //校验密码
        if (user.getPasswd().equals(passwd)) {
            throw new BaseException(MessageConstant.PASSWORD_ERROR);
        }

        return user;
    }
}
