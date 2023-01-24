package exercise18_01.graphics;


/**
 * IsoScelesTriangle
 * 
 * @author No&euml;l Vaes
 * @version 1.0
 */
public class IsoScelesTriangle extends Triangle {
   private static int count = 0;

   {
      count++;
   }
   
   /**
    * Create a IsoScelesTriangle with all dimensions set to 0 at position (0,0)
    */
   public IsoScelesTriangle() {
      this(0,0,0,0);
   }
   
   /**
    * Create a IsoScelesTriangle with specified dimensions set to 0 at position
    * (0,0)
    * 
    * @param width The width.
    * @param height
    *           The heigth.
    * @throws NegativeSizeException
    *            The width or hight is negative.
    */
   public IsoScelesTriangle(int width, int height) {
      this(width,height,0,0);
   }
   
   /**
    * Create a IsoScelesTriangle with specified dimensions and postion.
    * 
    * @param width The width.
    * @param height
    *           The height.
    * @param x
    *           X position.
    * @param y
    *           Y postion.
    * @throws NegativeSizeException
    *            The width or hight is negative.
    */
   public IsoScelesTriangle(int width, int height, int x, int y) {
      super(width,height,width/2,x,y);
   }
   
   /**
    * Creates a new IsoScelesTriangle based as a clone of an existing one.
    * 
    * @param tri
    *           Existing triangle to clone
    */
   public IsoScelesTriangle(IsoScelesTriangle tri){
      this(tri.getWidth(), tri.getHeight(), tri.getX(), tri.getY());
   }
   

   public void setWidth(int width){
      super.setWidth(width);
      super.setPerpendicular(width/2);
   }
   
   public void setPerpendicular(int perpendicular){
      super.setPerpendicular(perpendicular);
      super.setWidth(perpendicular*2);
   }
   
   public static int getCount() {
      return count;
   }

   @Override
   public String toString() {
      return String
            .format(
                  "IsoScelesTriangle [width=%s, height=%s, x=%s, y=%s]",
                  getWidth(), getHeight(), getX(), getY());
   }
   
}

