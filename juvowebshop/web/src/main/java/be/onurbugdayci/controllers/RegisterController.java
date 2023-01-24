package be.onurbugdayci.controllers;

import be.onurbugdayci.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService service;

    @GetMapping("/registration")
    public String forwardRegistration() {
        return "registration";
    }

    @PostMapping(value = "/registration", params = "action=signup")
    public String createUser(String username, String password) {
        service.createUser(username, password);
        return "redirect:myLogin";
    }

}
