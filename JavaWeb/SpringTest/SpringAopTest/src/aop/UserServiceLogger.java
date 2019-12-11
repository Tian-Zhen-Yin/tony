package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class UserServiceLogger {
    private static Logger log=Logger.getLogger(String.valueOf(UserServiceLogger.class));
    public void before(JoinPoint jp){
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature()+"方法，方法参数："+ Arrays.toString(jp.getArgs()));
    }
    public void afterReturning(JoinPoint jp,Object result){
        log.info("调用"+jp.getTarget()+"的"+jp.getSignature()+"方法，方法返回值："+result);
    }


}
