package com.nowcoder.communityQ.controller;

import com.nowcoder.communityQ.service.Aservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private Aservice aservice;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }
    @RequestMapping("/data")
    @ResponseBody
    public String grtData(){
        return aservice.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration= request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(request.getParameter("code"));
        //给浏览器返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer= response.getWriter();

            {
                writer.write("<h1>牛客网<h1>");
            }       } catch (IOException e) {
           e.printStackTrace();
        }
    }

    //GET请求

    //要查询所有的学生
    //查询路径 /students?current=1&limit=20
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "currentt",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path="/students/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }


    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);

        return "success";
    }

     //向浏览器相应动态的html
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    @RequestMapping(path = "/teacher1",method = RequestMethod.GET)
    public String getTeacher1(Model model){
        model.addAttribute("name","zhangsi");
        model.addAttribute("age","30");
         return "/demo/view";
    }

}
