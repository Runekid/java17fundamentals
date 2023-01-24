package be.onurbugdayci.beers.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Invalid beer id", code = HttpStatus.BAD_REQUEST)
public class InvalidBeerException extends Exception {

   public InvalidBeerException() {
      super();
   }

   public InvalidBeerException(String message, Throwable cause) {
      super(message, cause);
   }

   public InvalidBeerException(String message) {
      super(message);
   }

   public InvalidBeerException(Throwable cause) {
      super(cause);
   }
}
