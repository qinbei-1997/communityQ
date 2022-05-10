package com.nowcoder.communityQ.service;

import com.nowcoder.communityQ.dao.UserMapper;
import com.nowcoder.communityQ.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
