package net.homenet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class ProductAspect {
    public void before(JoinPoint joinPoint) {
        System.out.println("*** Before Aspect ***");
        System.out.println("\t- Method Name:" + joinPoint.getSignature().getName() + "()");
        System.out.println("\t- Arguments:" + joinPoint.getArgs()[0]);
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("*** After Aspect ***");
        System.out.println("\t- Method Name:" + joinPoint.getSignature().getName() + "()");
        System.out.println("\t- Arguments:" + joinPoint.getArgs()[0]);
    }

    public void afterReturning(Product product) {
        System.out.println("*** AfterReturning(Product Name:" + product.getName() + ") Aspect *** ");
    }

    public void afterThrowing(Throwable ex) {
        System.out.println("*** AfterThrowing Aspect ***");
        ex.printStackTrace();
    }

    public Product around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*** Around before aspect ***");
        Product product = (Product) joinPoint.proceed();
        System.out.println("*** Around after aspect ***");
        return product;
    }
}
