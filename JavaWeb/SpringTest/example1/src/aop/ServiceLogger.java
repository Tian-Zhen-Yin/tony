package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ServiceLogger {
    private static Logger logger=Logger.getLogger(String.valueOf(ServiceLogger.class));
    //�����ע�⣬ע����ʽ����д
    @Pointcut("execution(* service.UserService.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint jp){
        logger.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()+"����.������Σ�"
        + Arrays.toString(jp.getArgs()));
    }

  /*  @AfterReturning()
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("����"+jp.getTarget()+"��"+jp.getSignature().getName()+"����.��������ֵ��"
                + result);
    }
*/

}
