package exercise18_01.graphics;

import java.io.Serializable;

/**
 * Scaleable objects
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public interface Scaleable extends Serializable {
   /**
    * Scale the object.
    * 
    * @param factor
    *           Scale factor (%)
    */
   public abstract void scale(int factor);

   /** Scale 25% */
   public static final int QUARTER = 25;
   /** Scale 50% */
   public static final int HALF = 50;
   /** Scale 200% */
   public static final int DOUBLE = 200;
   
   /**Default method to scale to double size.
    */
   public default void scaleDouble() {
      scale(DOUBLE);
   }
   
   /**Default method to scale to half size.
    */
   public default void scaleHalf() {
      scale(HALF);
   }
}
