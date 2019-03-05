package com.yjs.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
@Aspect
public class DataSourceAspect {
    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut(value = "execution(* com.yjs.service.*.*(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        logger.info("切入点对象==>" + target);

        String method = joinPoint.getSignature().getName();
        logger.info("切入点方法签名==>" + method);

        Class<?> classz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature())
                .getMethod().getParameterTypes();

        try {

            Method m = classz.getMethod(method, parameterTypes);
            logger.info(m.getName());

            // 判断@DataSource注解是否在切入点方法的上，如果在上面，获取数据源对象并切换数据源
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                logger.info("切换数据源===》" + data.value());
                DynamicDataSourceHolder.setDataSource(data.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
