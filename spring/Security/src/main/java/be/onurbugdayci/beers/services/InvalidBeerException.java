package be.onurbugdayci.beers.services;

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
