package exercise18_01.graphics;

/**
 * A rectangle
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public class Rectangle extends Shape {

   private int width;
   private int height;
   /** Number of angles */
   public static final int ANGLES;
   private static int count;

   static {
      count = 0;
      ANGLES = 4;
   }

   {
      count++;
   }

   /**
    * Constructs a rectangle with width 0, height 0 on position (0,0)
    * 
    */
   public Rectangle() {
      this(0, 0, 0, 0);
   }

   /**
    * Creaates a rectangle on position (0,0) with specified dimensions
    * 
    * @param width
    *           The width.
    * @param height
    *           The height
    * @throws NegativeSizeException
    *            If the width or height is negative.
    */
   public Rectangle(int width, int height) {
      this(width, height, 0, 0);
   }

   /**
    * Creates a rectangle with specified dimensions on specified location
    * 
    * @param width
    *           The width
    * @param height
    *           The height
    * @param x
    *           The X-position
    * @param y
    *           The Y-position
    * @throws NegativeSizeException
    *            If the width or height is negative.
    */
   public Rectangle(int width, int height, int x, int y) {
      super(x, y);
      setWidth(width);
      setHeight(height);
   }

   /**
    * Creates a rectangle as a copy of another rectangle
    * 
    * @param rect The rectangle to copy
    */
   public Rectangle(Rectangle rect) {
      this(rect.width, rect.height, rect.getX(), rect.getY());
   }

   /**
    * Set the width
    * 
    * @param width
    *           The width
    * @throws NegativeSizeException
    *            If the width is negative.
    */
   public void setWidth(int width) {
      if (width < 0)
         throw new NegativeSizeException("Negative width");
      this.width = width;
   }

   /**
    * Get the width.
    * 
    * @return The width.
    */
   public int getWidth() {
      return width;
   }

   /**
    * Set the height
    * 
    * @param height
    *           The height
    * @throws NegativeSizeException
    *            If the height is negative.
    */
   public void setHeight(int height) {
      if (height < 0)
         throw new NegativeSizeException("Negative height");
      this.height = height;
   }

   /**
    * Get the height
    * 
    * @return The height
    */
   public int getHeight() {
      return height;
   }

   /**
    * Increase dimensions. The new dimensions are limited to 0.
    * 
    * @param d
    *           Width and height increment
    * @throws NegativeSizeException
    *            If the dimensions get negative.
    */
   public void grow(int d) {
      if(height < -d) throw new NegativeSizeException("Grow to negative height");
      if(width < -d) throw new NegativeSizeException("Grow to negative width");
      width += d;
      height += d;
   }

   public double getArea() {
      return width * height;
   }

   public double getPerimeter() {
      return (width + height) * 2;
   }

   /**
    * Get the number of rectangles.
    * @return The number of rectangles.
    */
   public static int getCount() {
      return count;
   }

   @Override
   public String toString() {
      return String.format("Rectangle [width=%s, height=%s, x=%s, y=%s]",
            width, height, getX(), getY());
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + height;
      result = prime * result + width;
      return result;
   }

   /**
    * Compares the rectangle with another object. Two rectangles are equal if
    * they have the same dimensions and position.
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
      Rectangle other = (Rectangle) obj;
      if (height != other.height)
         return false;
      if (width != other.width)
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
      height = (int) (height * f);
      width = (int) (width * f);
   }

}
