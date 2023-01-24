package exercise18_01.graphics;
/**
 * This exceptions is thrown when negative sizes are used at places where
 * negative dimensions are not allowed.
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public class NegativeSizeException extends IllegalArgumentException {

   public NegativeSizeException() {
      super();
   }

   public NegativeSizeException(String message, Throwable cause) {
      super(message, cause);
   }

   public NegativeSizeException(String message) {
      super(message);
   }

   public NegativeSizeException(Throwable cause) {
      super(cause);
   }
   
}
