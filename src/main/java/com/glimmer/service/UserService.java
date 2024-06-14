package com.glimmer.service;

import com.glimmer.dto.LoginDto;
import com.glimmer.model.User;

public interface UserService {
    User login(LoginDto userLoginDTO);
}
