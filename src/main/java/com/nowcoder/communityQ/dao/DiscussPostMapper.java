package com.nowcoder.communityQ.dao;

import com.nowcoder.communityQ.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper

public interface DiscussPostMapper {

   List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

   //@Param 用于给参数起别名，
    //如果这个方法只有一个参数，并且在<if>中使用，则必须加别名
   int selectDiscussPostsRows(@Param("userId") int userId);
}
