package net.homenet;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspect {
    @Before("execution(* findProduct(String))")
    public void before() {
        System.out.println("*** Before Aspect ***");
    }

    @After("execution(* findProduct(String))")
    public void after() {
        System.out.println("*** After Aspect ***");
    }

    @AfterReturning(value = "execution(* findProduct(String))", returning = "product")
    public void afterReturning(Product product) {
        System.out.println("*** AfterReturning(Product Name:" + product.getName() + ") Aspect *** ");
    }

    @AfterThrowing(value = "execution(* findProduct(String))", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("*** AfterThrowing Aspect ***");
        ex.printStackTrace();
    }

    @Around("execution(* findProduct(String))")
    public Product around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*** Around before aspect ***");
        Product product = (Product) joinPoint.proceed();
        System.out.println("*** Around after aspect ***");
        return product;
    }
}
