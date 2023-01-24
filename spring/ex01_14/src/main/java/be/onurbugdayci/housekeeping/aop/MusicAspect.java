package be.onurbugdayci.housekeeping.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MusicAspect {

    @DeclareParents(value = "be.onurbugdayci.housekeeping.services.DomesticServiceImpl", defaultImpl = MusicMakerImpl.class)
    public static MusicMaker mixin;
}
