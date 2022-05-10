package com.nowcoder.communityQ;

import com.nowcoder.communityQ.dao.DiscussPostMapper;
import com.nowcoder.communityQ.dao.UserMapper;
import com.nowcoder.communityQ.entity.DiscussPost;
import com.nowcoder.communityQ.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ContextConfiguration(classes = CommunityQApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user;
        user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void selectDiscussPosts(){
        List<DiscussPost> discussPosts=discussPostMapper.selectDiscussPosts(0,0,10);
        for (DiscussPost post:discussPosts){
            System.out.println(post);
        }

    }
}
