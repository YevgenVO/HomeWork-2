package com.gmail.yevgen.v.o;

public class Square implements Shape{
    double side;
    double perimeter;
    double area;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }


    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        this.area = side * side;
        return area;
    }
    public double getPerimeter() {
        this.perimeter = 4 * side;
        return perimeter;
    }

    public String toFileWriterString () {
        return "\n\t\t<Square>\n\t\t\t<side>" + side + "</side>\n\t\t</Square>";

    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
