package be.onurbugdayci.housekeeping.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {

    @Before("execution(* *.runHouseHold(..))")
    public void before() {
        System.out.println("before run household");
    }

    @AfterThrowing("execution(* *.runHouseHold(..))")
    public void afterException() {
        System.out.println("after exception run household");
    }

    @After("execution(* *.runHouseHold(..))")
    public void after() {
        System.out.println("after run household");
    }
}
