package be.onurbugdayci.mvc.controller;

import be.onurbugdayci.mvc.services.SecureBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecureController {
   
   @Autowired
   private SecureBean bean;
   
   @RequestMapping("/secure")
   public ModelAndView handleSecure() {
      String message = bean.getSecret();
      return new ModelAndView("secret","message",message);
   }
}
