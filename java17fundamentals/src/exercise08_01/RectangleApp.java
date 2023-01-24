package exercise08_01;

import static exercise08_01.Rectangle.*;
import static java.lang.Math.*;

public class RectangleApp {
    public static void main(String[] args) {
        System.out.println("This program uses a rectangle");
        Rectangle rectangle = new Rectangle();
        rectangle.setX(1);
        rectangle.setY(2);
        rectangle.setWidth(3);
        rectangle.setHeight(4);
        System.out.println(rectangle.getX());
        System.out.println(rectangle.getY());
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getHeight());

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(6);
        rectangle2.setY(7);
        rectangle2.setWidth(8);
        rectangle2.setHeight(9);
        System.out.println(rectangle2.getX());
        System.out.println(rectangle2.getY());
        System.out.println(rectangle2.getWidth());
        System.out.println(rectangle2.getHeight());
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle2.getPerimeter());

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setX(6);
        rectangle3.setY(7);
        rectangle3.setWidth(-8);
        rectangle3.setHeight(-9);
        System.out.println(rectangle3.getX());
        System.out.println(rectangle3.getY());
        System.out.println(rectangle3.getWidth());
        System.out.println(rectangle3.getHeight());
        System.out.println(rectangle3.getArea());
        System.out.println(rectangle3.getPerimeter());

        Rectangle rectangle4 = new Rectangle(8,9);
        System.out.println(rectangle4.getWidth());
        System.out.println(rectangle4.getHeight());
        System.out.println(rectangle4.getArea());
        System.out.println(rectangle4.getPerimeter());

        Rectangle rectangle5 = new Rectangle(8,9,5,6);
        System.out.println(rectangle5.getX());
        System.out.println(rectangle5.getY());
        System.out.println(rectangle5.getWidth());
        System.out.println(rectangle5.getHeight());
        System.out.println(rectangle5.getArea());
        System.out.println(rectangle5.getPerimeter());

        System.out.println(Rectangle.ANGLES);

        System.out.println(Rectangle.getCount());
        System.out.println(ANGLES);

        System.out.println(getCount());


        for(float angle = 0; angle <= (2*PI); angle+=0.1) {
            System.out.printf("%.1f %.0f %.2f%n", angle,toDegrees(angle),cos(angle));
        }
    }
}
