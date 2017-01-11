package test.aspect;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * TODO: Add doc
 * Created by Nikita on 11.01.2017.
 */
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);


    @Pointcut("execution(* *.*(..))")
    private void logAll() {
    }

/*    @Before("logAll()")
    public void logSimpleBefore(JoinPoint point) {
        final Signature signature = point.getSignature();
        final String name = signature.getName();
        final Object[] args = point.getArgs();
        final String className = signature.getDeclaringType().getSimpleName();
        LOGGER.info(String.format("%s.%s(%s)", className, name, Arrays.toString(args)));
    }*/

    @AfterReturning(pointcut = "logAll()", returning = "returnArgs")
    public void logSimpleAfter(JoinPoint point,Object returnArgs) {
        final Signature signature = point.getSignature();
        final String name = signature.getName();
        final Object[] args = point.getArgs();
        final String className = signature.getDeclaringType().getSimpleName();
        LOGGER.info(String.format("%s.%s(%s): %s", className, name, Arrays.toString(args),returnArgs));
    }
}
