package be.onurbugdayci.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selectage")
public class SelectAgeController {

    @GetMapping
    public String handleGet() {
        return "selectAgeView";
    }

    @PostMapping(params = { "submit", "category=child" })
    public String handleChild() {
        System.out.println("Child entered site");
        return "children"; //url of selectage stays
    }

    @PostMapping(params = { "submit", "category=teenager" })
    public String handleTeenager() {
        System.out.println("Teenager entered site");
        return "redirect:teenager"; //will replace the url from before with url for teenager but you have to add a ViewController to the registry
    }

    @PostMapping(params = { "submit", "category=adult" })
    public String handleAdult() {
        System.out.println("Adult entered site");
        return "redirect:adult";
    }

    @PostMapping(params = { "cancel" })
    public String handleCancel() {
        System.out.println("Canceled");
        return "redirect:cancel";
    }

    @PostMapping
    public String handleEmpty() {
        return "redirect:selectage";
        //return "exercise05/selectage";
    }
}
