package be.onurbugdayci.housekeeping.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
public class DisposableDuster implements CleaningTool{
    private boolean used = false;

    @Override
    public void doCleanJob() {
        if (used) {
            System.out.println("Already used this duster");
        } else {
            System.out.println("Duster is being used");
            used = true;
        }
    }


}
