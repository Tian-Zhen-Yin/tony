package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //实现过滤行为
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //所有中文统一编码
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(request,response);
    }
    //过滤器的销毁
    @Override
    public void destroy() {
        System.out.println("销毁>>>>>>>");
    }
    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("doFilter>>>>>>>");
    }
}
