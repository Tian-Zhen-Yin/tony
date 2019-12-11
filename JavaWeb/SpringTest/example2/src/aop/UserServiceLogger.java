package aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class UserServiceLogger {
    private static Logger logger=Logger.getLogger(String.valueOf(UserServiceLogger.class));
    //切入点注解，注意表达式的书写
    @Pointcut("execution(* service.UserService.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint jp){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法入参："
        + Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法.方法返回值："
                + result);
    }


}
