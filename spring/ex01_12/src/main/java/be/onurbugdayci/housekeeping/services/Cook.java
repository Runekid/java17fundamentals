package be.onurbugdayci.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class Cook {
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener(ContextStartedEvent.class)
    @Order(2)
    public void makeLunch() {
        System.out.println("Making a great lunch");
        publisher.publishEvent(new LunchEvent());
    }
}
