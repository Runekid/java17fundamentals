package be.onurbugdayci.mvc.controller;

import be.onurbugdayci.mvc.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private HelloService service;

    @RequestMapping("hello")
    public ModelAndView handleHello() {
        String text = service.sayHello();
        return new ModelAndView("helloView","message",text);
    }

}
