package com.nowcoder.communityQ.service;

import com.nowcoder.communityQ.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("singleton") //默认单例模式
//@Scope("prototype")//每次访问bean 都会出现一个新的实例
public class Aservice {
    @Autowired
    private AlphaDao alphaDao;
    public Aservice(){
        System.out.println("实例化");
    }
    @PostConstruct
    //构造器之后调用
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    //销毁对象之前调用
    public void destory(){
        System.out.println("销毁");
    }

    public String find(){
        return alphaDao.select();
    }
}
