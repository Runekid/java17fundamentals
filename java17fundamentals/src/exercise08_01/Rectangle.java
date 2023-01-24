package exercise08_01;


public class Rectangle {
    private int x;
    private int y;
    private int height;
    private int width;

    public static final int ANGLES;
    private static  int count = 0;

    public static int getCount() {
        return count;
    }

    static {
        ANGLES = 4;
    }

    {
        count++;
    }

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(int width, int height) {
        this(width,height,0,0);
    }

    public Rectangle(int width, int height, int x, int y) {
        this.setHeight(height);
        this.setWidth(width);
        this.setX(x);
        this.setY(y);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getWidth(), rectangle.getHeight(), rectangle.getX(), rectangle.getY());
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height < 0 ? -height : height;
    }

    public void setWidth(int width) {
        this.width = width < 0 ? -width : width;
    }

    public void grow(int d) {
        int absD = d < 0 ? -d : d;
        this.setHeight(this.height + absD);
        this.setWidth(this.width + absD);
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.height + this.width) * 2;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
