package eu.it.academy.logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//package eu.it.academy.services;

@Service
@Aspect
public class ServiceLogger {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogger.class);

    @AfterThrowing(pointcut = "execution(* eu.it.academy.services.*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        logger.error(exception.getMessage());
    }
}
