package be.onurbugdayci.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("modelResult")
@RequestMapping("/calculator")
@ApplicationScope
public class CalculatorController {
    @GetMapping
    public String forward(ModelMap model) {
        if (model.get("modelResult") == null) model.addAttribute("modelResult",0F);
        return "calculator";
    }

    @PostMapping
    public String handleCalc(ModelMap model,@RequestParam(value = "number", defaultValue = "0") float number, @RequestParam(value = "op") String op) {
        Float res = (Float) model.get("modelResult");
        float result = 0;
        if (res != null) {
            result = res;
        }
        switch (op) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
        }
        model.addAttribute("modelResult", result);
        return "redirect:calculator";
    }
}
