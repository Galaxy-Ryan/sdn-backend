package com.glimmer.controller;

import com.glimmer.constant.JwtClaimsConstant;
import com.glimmer.constant.MessageConstant;
import com.glimmer.dto.LoginDto;
import com.glimmer.model.User;
import com.glimmer.properties.JwtProperties;
import com.glimmer.result.Result;
import com.glimmer.service.UserService;
import com.glimmer.utils.JwtUtil;
import com.glimmer.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserLoginVO> UserLogin(@RequestBody LoginDto userLoginDTO){
        //在这里输出日志，便于后续排查错误，解决问题
        log.info("用户登录:{}",userLoginDTO);
        //调用service层的接口，返回查询到的user对象
        User user = userService.login(userLoginDTO);

        //登录成功后，为用户生成jwt令牌
        Map<String,Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID,user.getId());
        String token = JwtUtil.createJWT(jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);

        //链式构造可供返回给前端的视图模型对象,为其设置相关属性
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .message(MessageConstant.LOGIN_SUCCESS)
                .status(0)
                .authorization(token)
                .build();

        //返回响应结果
        return Result.success(userLoginVO,MessageConstant.LOGIN_SUCCESS);
    }
}
