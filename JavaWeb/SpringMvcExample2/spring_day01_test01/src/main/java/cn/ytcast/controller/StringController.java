package cn.ytcast.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/string")
public class StringController  {
@RequestMapping("/testString")
public String testReturnString(){
    System.out.println("StringController 的 testReturnString 方法执行了。。。。");
    return "success";
}
@RequestMapping("/testVoid")
public void testReturnVoid(HttpServletRequest request, HttpServletResponse response)throws Exception{
    //转发
    /*request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,
            response);*/
    //重定向
    response.sendRedirect("testString");
}
@RequestMapping("/testModelAndView")
public ModelAndView testReturnModelAndView(){
    ModelAndView mv=new ModelAndView();
    mv.addObject("name","李四");
    mv.setViewName("success");
    return mv;
}
}
