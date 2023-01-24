package be.onurbugdayci.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sum")
public class SumController {
    @GetMapping
    public String handleGet() {
        return "sum";
    }

    @PostMapping
    public ModelAndView handleTeenager(@RequestParam(value = "number1", defaultValue = "0") float number1
            , @RequestParam(value = "number2" , defaultValue = "0") float number2) {
        float sum = number1 + number2;
        return new ModelAndView("sum", "sum", sum);
    }
}
