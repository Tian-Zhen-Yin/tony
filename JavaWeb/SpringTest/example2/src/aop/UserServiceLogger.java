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
    //�����ע�⣬ע����ʽ����д
    @Pointcut("execution(* service.UserService.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint jp){
        logger.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()+"����.������Σ�"
        + Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()+"����.��������ֵ��"
                + result);
    }


}
