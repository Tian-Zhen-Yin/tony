package cn.ytcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * 预处理，controller方法执行前，进行拦截的方法
     * return true 放行，执行下一个拦截器，如果没有下一个拦截器，就执行controller
     * return false 拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理：拦截器执行了。。。前2222");
        /*  request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);*/
        return true;
    }

    /**
     *h后处理方法，controller方法执行后，success.jsp执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor执行了之后2222");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

    }

    /**
     * 在success.jsp执行后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor：最后2222");
    }
}
