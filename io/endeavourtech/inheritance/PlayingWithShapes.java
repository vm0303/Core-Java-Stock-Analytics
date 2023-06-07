package io.endeavourtech.inheritance;

import java.math.BigDecimal;

public class PlayingWithShapes
{
    public static void main(String[] args) {
        Square square1 = new Square(new BigDecimal("10"));
        System.out.println("Area of Square 1 is "+ square1.calculateArea());

        Square square2 = new Square(new BigDecimal("5"));
        System.out.println("Area of Square 1 with side " + square2.getSide() + " is " + square2.calculateArea());

        //A reference variable of Interface type can point to and object af a class that implements the interface
        Shape rectangle1 = new Rectangle(new BigDecimal("5"), new BigDecimal(10));
        System.out.println("Area of rectangle 1 is " + rectangle1.calculateArea());

        Circle circle1 = new Circle(new BigDecimal("15"));
        System.out.println("Area of circle 1 is " + circle1.calculateArea());

        Shape[] shapesArr = new Shape[]{square1, square2, rectangle1,circle1};
        System.out.println("The total area for all the shapes is " + calculateTotalArea(shapesArr));
    }

    private static BigDecimal calculateTotalArea(Shape[] shapesArr) {
        BigDecimal totalArea = BigDecimal.ZERO;
        for (Shape eachShape : shapesArr) {
            totalArea = totalArea.add(eachShape.calculateArea());
        }
        return totalArea;
    }
}
