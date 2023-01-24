package be.onurbugdayci.mvc.services;

import org.springframework.security.access.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class SecureBeanImpl implements SecureBean {
   @Secured("ROLE_ADULT")
   public String getSecret() {      
      return "This is a secret";
   }
}
