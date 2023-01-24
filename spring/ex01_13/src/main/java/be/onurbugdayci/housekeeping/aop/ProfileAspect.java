package be.onurbugdayci.housekeeping.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@Aspect
public class ProfileAspect {

    @Around("execution(* *.runHouseHold(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();
        System.out.println("before proceeding");
        Object returnValue = pjp.proceed();
        System.out.println("After proceeding");
        Instant stop = Instant.now();
        long duration = ChronoUnit.MILLIS.between(start, stop);
        System.out.println("Duration: " + duration + " ms");
        return returnValue;
    }
}
