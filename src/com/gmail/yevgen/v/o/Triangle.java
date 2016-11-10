package com.gmail.yevgen.v.o;

public class Triangle implements Shape{
    private double aSide;
    private double bSide;
    private double cSide;
    private double area;
    private double perimeter;

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    public Triangle(double aSide, double bSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = aSide;
    }

    public Triangle(double aSide) {
        this.aSide = aSide;
        this.bSide = aSide;
        this.cSide = aSide;
    }

    public double getaSide() {
        return aSide;
    }

    public void setaSide(double aSide) {
        this.aSide = aSide;
    }

    public double getbSide() {
        return bSide;
    }

    public void setbSide(double bSide) {
        this.bSide = bSide;
    }

    public double getcSide() {
        return cSide;
    }

    public void setcSide(double cSide) {
        this.cSide = cSide;
    }

    public double getPerimeter(){
        this.perimeter = aSide + bSide + cSide;
        return perimeter;
    }

    public double getArea(){
        double semiPerimeter;
        semiPerimeter = (aSide + bSide + cSide)/2;
        area = Math.sqrt((semiPerimeter - aSide) * (semiPerimeter - bSide) * (semiPerimeter - cSide) * semiPerimeter);
        return area;
    }
    public String toFileWriterString () {
        return "\n\t\t<Triangle>\n\t\t\t<aSide>" + aSide
                + "</aSide>\n\t\t\t<bSide>" + bSide + "</bSide>\n\t\t\t<cSide>"
                + cSide + "</cSide>\n\t\t</Triangle>";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "aSide=" + aSide +
                ", bSide=" + bSide +
                ", cSide=" + cSide +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
