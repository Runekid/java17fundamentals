package exercise18_01.graphics;

/**
 * A triangle.
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public class Triangle extends Shape {
   private int width;
   private int height;
   private int perpendicular;

   /**
    * The number of angles for this shape.
    */
   public static final int ANGLES = 3;
   private static int count = 0;

   {
      count++;
   }
   /**
    * Creates a triangle with all dimensions set to 0 at position (0,0)
    */
   public Triangle() {
      this(0, 0, 0, 0, 0);
   }

   /**
    * Creates a triangle with specified dimensions at position (0,0).
    * 
    * @param width
    *           The width.
    * @param height
    *           The height.
    * @param perpendicular
    *           The perpendicular.
    * @throws NegativeSizeException
    *            The width or hight is negative.
    */
   public Triangle(int width, int height, int perpendicular) {
      this(width, height, perpendicular, 0, 0);
   }
   
   /**
    * Creates a triangle with specified dimensions at specified
    * location.
    * 
    * @param width
    *           The width.
    * @param height
    *           The height.
    * @param perpendicular
    *           The perpendicular.
    * @param x
    *           X position
    * @param y
    *           Y position
    * @throws NegativeSizeException
    *            The width or hight is negative.
    */
   public Triangle(int width, int height, int perpendicular,
         int x, int y) {
      super(x, y);
      setWidth(width);
      setHeight(height);
      setPerpendicular(perpendicular);
   }
   /**
    * Creates a triangle as clone of an existing triangle.
    * 
    * @param tri
    *           Triangle to clone.
    */
   public Triangle(Triangle tri) {
      this(tri.width, tri.height, tri.perpendicular, tri.getX(),
            tri.getY());
   }
   /**
    * Set the width. The width can not be negative.
    * 
    * @param width
    *           The width.
    * @throws NegativeSizeException
    *            The width is negative.
    */
   public void setWidth(int width) {
      if (width < 0)
         throw new NegativeSizeException("Negative width");
      this.width = width;
   }
   /**
    * Set the height. The heigth can not be negative.
    * 
    * @param height
    *           The heigth.
    */
   public void setHeight(int height) {
      if (height < 0)
         throw new NegativeSizeException("Negative height");
      this.height = height;
   }
   /**
    * Set the perpendicular.
    * 
    * @param perpendicular
    *           The perpendicular.
    */
   public void setPerpendicular(int perpendicular) {
      this.perpendicular = perpendicular;
   }

   public double getArea() {
      return (width * height) / 2;
   }

   public double getPerimeter() {
      return width + Math.hypot(height, perpendicular)
            + Math.hypot(height, (width - perpendicular));
   }

   public int getWidth() {
      return width;
   }

   public int getHeight() {
      return height;
   }
   /**
    * Get the perpendicular
    * 
    * @return The perpendicular.
    */
   public int getPerpendicular() {
      return perpendicular;
   }
   /**
    * Get the number of created triangles.
    * 
    * @return The number of triangles.
    */
   public static int getCount() {
      return count;
   }

   @Override
   public String toString() {
      return String
            .format(
                  "Triangle [width=%s, height=%s, perpendicular=%s, x=%s, y=%s]",
                  width, height, perpendicular, getX(), getY());
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

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + height;
      result = prime * result + perpendicular;
      result = prime * result + width;
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      Triangle other = (Triangle) obj;
      if (height != other.height)
         return false;
      if (perpendicular != other.perpendicular)
         return false;
      if (width != other.width)
         return false;
      return true;
   }

}

