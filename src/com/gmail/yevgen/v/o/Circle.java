package com.gmail.yevgen.v.o;

public class Circle implements Shape{
    String shapeType = "Circle";
    double radius;
    double perimeter;
    double area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        this.perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public double getArea() {
        this.area = Math.PI * radius * radius;
        return area;
    }

    public String toFileWriterString () {
        return "\n\t\t<" + shapeType  + ">\n\t\t\t<radius>" + radius +
                "</radius>\n\t\t</" + shapeType + ">";

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + getPerimeter() +
                ", area=" + getArea() +
                '}';
    }
}
