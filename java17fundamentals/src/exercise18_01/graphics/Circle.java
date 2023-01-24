package exercise18_01.graphics;

/**
 * A circle
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public class Circle extends Shape {

   private int radius;

   /** The number of angles for this shape. */
   public static final int ANGLES = 0;
   private static int count = 0;

   {
      count++;
   }

   /**
    * Creates a circle on position (0,0) with radius 0.
    * 
    */
   public Circle() {
      this(0, 0, 0);
   }

   /**
    * Creates a circle on position (0,0) with the specified radius.
    * 
    * @param radius
    *           The initial radius.
    */
   public Circle(int radius) {
      this(radius, 0, 0);
   }

   /**
    * Creates a circle on the specified position with the specified radius.
    * 
    * @param radius The initial radius.
    * @param x The x position.
    * @param y The y position.
    * @throws NegativeSizeException If the radius is negative.
    */
   public Circle(int radius, int x, int y) {
      super(x, y);
      setRadius(radius);
   }

   /**Create a circle as copy of an existing circle
    * @param circ Existing circle to clone.
    * @throws NegativeSizeException If the radius is negative.
    */
   public Circle(Circle circ) {
      this(circ.radius, circ.getX(), circ.getY());
   }

   /**Set the radius. This should be a positive value.
    * @param radius The new radius.
    * @throws NegativeSizeException If the radius is negative.
    */
   public void setRadius(int radius) {
      if (radius < 0)
         throw new NegativeSizeException("Negative radius");
      this.radius = radius;

   }

   /**Get the radius
    * @return The radius.
    */
   public int getRadius() {
      return radius;
   }

   /**Grow circle with radius increment.
    * @param dr The radius increment.
    * @throws NegativeSizeException If the radius gets negative.
    */
   public void grow(int dr) {
      if (radius < -dr)
         throw new NegativeSizeException(
               "Grow to negative radius");
      radius += dr;
   }

   public double getArea() {
      return Math.PI * radius * (double) radius;
   }

   public double getPerimeter() {
      return 2 * Math.PI * (double) radius;
   }

   public static int getCount() {
      return count;
   }

   @Override
   public String toString() {
      return String.format("Circle [radius=%s, x=%s, y=%s]",
            radius, getX(),
            getY());
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + radius;
      return result;
   }

   /**
    * Compares the circle with another object. Two circles are equal
    * if they have the same radius and position.
    * 
    * @param obj
    *           The other object to compare with.
    * @return True if the objects are equal.
    */

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      Circle other = (Circle) obj;
      if (radius != other.radius)
         return false;
      return true;
   }

   @Override
   public void draw(DrawingContext dc) {
      dc.draw(this);
   }

   @Override
   public void scale(int factor) {
      double f = Math.sqrt(factor) / 10;
      radius = (int) (radius * f);
   }

}
