package com.gmail.yevgen.v.o;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Group {
    private List<Shape> shapes = new ArrayList<Shape>();
    private String groupName;
    private static List<Group> groups = new ArrayList<Group>();
    private Scanner scanner = new Scanner(System.in);
    private static FileWriter groupSaver;

    public Group(String groupName) {
        this.groupName = groupName;
        groups.add(this);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public String getGroupName() {
        return groupName;
    }

    public static List<Group> getGroups() {
        return groups;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public int addShape() {
        int i;
        for (i = 2; i == 2; ) {
            System.out.println("Create Triangle: input 1");
            System.out.println("Create Circle: input 2");
            System.out.println("Create Square: input 3");
            System.out.println("Back to the previous menu: input 4");
            System.out.println("Exit: input 0");
            switch (scanner.nextInt()) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    addTriangle();
                    break;
                case 2:
                    addCircle();
                    break;
                case 3:
                    addSquare();
                    break;
                case 4:
                    i = 1;
                    break;
                default:
                    System.out.println("Try again!");
                    break;
            }
        }
        return i;
    }

    private void addTriangle() {
        System.out.println("All sides are different: input 1");
        System.out.println("Isosceles triangle: input 2");
        System.out.println("Equilateral triangle: input 3");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Input 3 sides.");
                shapes.add(new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
                break;
            case 2:
                System.out.println("Input 2 sides.");
                shapes.add(new Triangle(scanner.nextDouble(), scanner.nextDouble()));
                break;
            case 3:
                System.out.println("Input 1 side.");
                shapes.add(new Triangle(scanner.nextDouble()));
                break;
            default:
                System.out.println("Try again!");
                break;
        }
    }

    private void addCircle() {
        System.out.println("Input radius.");
        shapes.add(new Circle(scanner.nextDouble()));
    }

    private void addSquare() {
        System.out.println("Input side.");
        shapes.add(new Square(scanner.nextDouble()));
    }

    public static boolean groupSaver() throws IOException {
        groupSaver = new FileWriter("src/com/gmail/yevgen/v/o/groupSave.xml");
        BufferedWriter bufferedWriter = new BufferedWriter(groupSaver);
        bufferedWriter.write("<Groups>");
        for (Group group : Group.getGroups()) {
            bufferedWriter.write("\n\t<Group>\n\t\t<GroupName>" + group.getGroupName() + "</GroupName>");
            for (Shape shape : group.getShapes()) {
                bufferedWriter.write(shape.toFileWriterString());
            }
            bufferedWriter.write("\n\t</Group>");
        }
        bufferedWriter.write("\n</Groups>");
        bufferedWriter.close();

        return true;
    }

}
