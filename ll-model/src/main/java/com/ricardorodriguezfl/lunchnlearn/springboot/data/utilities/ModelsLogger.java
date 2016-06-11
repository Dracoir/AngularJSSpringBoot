package com.ricardorodriguezfl.lunchnlearn.springboot.data.utilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Inserts logging aspects into all the objects' methods in the Lunch and Learn package
 * 
 * @author Ricardo Rodriguez
 *
 */
@Aspect
@Component
public class ModelsLogger {

	/** Handle to the log file */
    private final Log log = LogFactory.getLog(getClass());

    public ModelsLogger() {}

    /** Executed at the beginning of every method call, for the given package **/
    @Before("execution(* com.ricardorodriguezfl.lunchnlearn..*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        log.info("***** Starting " + joinPoint.getSignature().getDeclaringType().getSimpleName().toUpperCase() + ": " + joinPoint.getSignature().getName() + " *****");
    }

    /** Executed at the end of every method call, for the given package **/
    @AfterReturning("execution(* com.ricardorodriguezfl.lunchnlearn..*.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
        log.info("***** Completed " + joinPoint.getSignature().getDeclaringType().getSimpleName().toUpperCase() + ": " + joinPoint.getSignature().getName() + " *****");
    }

}
