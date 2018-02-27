package com.huashu.huashuManager.auth.service;

import com.huashu.huashuManager.mapper.UsersMapper;
import com.huashu.huashuManager.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users getUser(Users user) {
        return usersMapper.select(user);
    }
}
