package com.vaadin.trainings.routing.test;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.trainings.routing.HomeView;
import com.vaadin.trainings.routing.LotteryView;
import org.junit.Assert;
import org.junit.Test;

public class SmokeTest {

    @Test
    public void viewsShouldNotHaveRouteAnnotations(){
        Assert.assertNull(HomeView.class.getAnnotation(Route.class));
        Assert.assertNull(HomeView.class.getAnnotation(RouteAlias.class));

        Assert.assertNull(LotteryView.class.getAnnotation(Route.class));
        Assert.assertNull(LotteryView.class.getAnnotation(RouteAlias.class));
    }
}
