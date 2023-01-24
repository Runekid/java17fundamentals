package be.onurbugdayci.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
@RequestScope
public class CounterController {
    private int count = 0;

    @PostConstruct
    public void init() {
        System.out.println("CounterController: init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CounterController: destroy()");
    }

    @RequestMapping("counter")
    protected ModelAndView handle() {
        return new ModelAndView("counterView", "count", ++count);
    }
}
