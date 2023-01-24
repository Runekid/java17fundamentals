package be.onurbugdayci.mvc.controller;

import be.onurbugdayci.mvc.domain.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
      
   @ModelAttribute("optionList")
   public String[] getOptions() {
      return new String[] {"Alarm","Handsfree carkit","MP3 player", "Sport pack" };
   }
   
   @GetMapping
   public String showForm(@ModelAttribute("vehicle") Vehicle vehicle) {
      return "VehicleForm";
   }
   
   @PostMapping
   public String handleForm(@ModelAttribute("vehicle") @Valid Vehicle vehicle, BindingResult br) {
      if(br.hasErrors()) {
         for(ObjectError error: br.getAllErrors()) {      
            for(String code: error.getCodes()) {
               System.out.println(code);
            }
         }
         return "VehicleForm";
      }
      System.out.println(vehicle.getBrand());
      return "VehicleConfirm";
   }   
}
