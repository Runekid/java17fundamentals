package be.onurbugdayci.housekeeping.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Aspect
public class TimeAspect {
   private int startHour;
   private int endHour;
  
   @Value("${timeAspect.startHour}")
   public void setStartHour(int startHour) {
      this.startHour = startHour;
   }

   @Value("${timeAspect.endHour}")
   public void setEndHour(int endHour) {
      this.endHour = endHour;
   }
      
   @Before("execution(* *.VacuumCleaner.doCleanJob(..))")
   public void checkTime() {
      LocalTime now = LocalTime.now();
      int hour = now.getHour();
      if(hour < startHour || hour >= endHour) {
         throw new TimeException("Operation not allowed at this time of the day");
      }
   }
}
