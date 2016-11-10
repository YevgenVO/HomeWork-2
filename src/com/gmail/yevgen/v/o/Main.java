package com.gmail.yevgen.v.o;

import java.io.IOException;

public class Main {
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        try {
            LoadGroups.loadGroups();
            viewGroups();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException");
        } catch (IOException e) {
            System.out.println(e);
        }
        for (int i = 1; i == 1; ) {
            System.out.println("Add shape to new Group: input 1");
            if (Group.getGroups().size() > 0) {
                System.out.println("Add shape to existing Group: input 2");
                System.out.println("View Groups: input 3");
                System.out.println("Save Groups: input 4");
            }
            System.out.println("Exit: input 0");
            switch (scanner.nextInt()) {
                case 0:
                    i = 0;
                    scanner.close();
                    break;
                case 1:
                    i = createGroup().addShape();
                    break;
                case 2:
                    i = addShape();
                    break;
                case 3:
                    viewGroups();
                    break;
                case 4:
                    try {
                        Group.groupSaver();
                    } catch (IOException e) {
                        System.out.println("Failed on saving" + e);
                    }
                    break;
                default:
                    System.out.println("Try again!");
                    break;
            }
        }
    }


    public static Group createGroup() {
        return new Group("Group" + (Group.getGroups().size() + 1));
    }

    public static int addShape() {
        int i = 1;
        System.out.println("Choose one of Groups.");
        for (Group group : Group.getGroups()) {
            System.out.println(i++ + ": " + group.getGroupName() + ".");
        }
        Group group = Group.getGroups().get(scanner.nextInt() - 1);
        i = group.addShape();
        return i;
    }

    public static void viewGroups() {
        int i = 1;
        for (Group group : Group.getGroups()) {
            int j = 1;
            System.out.println(i + ". " + group.getGroupName());
            for (Shape shape : group.getShapes()) {
                System.out.print("\t" + shape.toString());
                System.out.println();
                j++;
            }
            i++;
        }
        System.out.println();
    }
}
