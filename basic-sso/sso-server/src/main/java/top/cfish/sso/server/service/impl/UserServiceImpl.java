package top.cfish.sso.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cfish.sso.server.dao.UserMapper;
import top.cfish.sso.server.model.User;
import top.cfish.sso.server.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(User user)
    {
        return userMapper.find(user);
    }
}
