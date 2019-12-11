package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class UserServiceLogger {
    private static Logger log=Logger.getLogger(String.valueOf(UserServiceLogger.class));
    public void before(JoinPoint jp){
        log.info("����"+jp.getTarget()+"��"+jp.getSignature()+"����������������"+ Arrays.toString(jp.getArgs()));
    }
    public void afterReturning(JoinPoint jp,Object result){
        log.info("����"+jp.getTarget()+"��"+jp.getSignature()+"��������������ֵ��"+result);
    }


}
