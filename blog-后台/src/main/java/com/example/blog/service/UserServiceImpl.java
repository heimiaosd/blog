package com.example.blog.service;

import com.example.blog.dao.UserRepository;
import com.example.blog.po.User;
import com.example.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) throws Exception {
        User user = userRepository.findByUsernameAndPassword(username, MD5Util.md5NotKey(password));
        return user;
    }
}
