package com.gmail.yevgen.v.o;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadGroups {
    private static FileReader groupsLoader;
    private static String line;
    private static int lineIndex = 0;
    private static int firstIndex = 0;
    private static int lastIndex = 0;
    private final static String CIRCLE_NODE = "<Circle>";
    private final static String TRIANGLE_NODE = "<Triangle>";
    private final static String SQUARE_NODE = "<Square>";

    public static void loadGroups() throws IOException, ClassCastException {
        groupsLoader = new FileReader("src/com/gmail/yevgen/v/o/groupSave.xml");
        BufferedReader br = new BufferedReader(groupsLoader);
        line = br.readLine();
        while (line != null) {
            if (line.startsWith("<Group>", line.indexOf("<"))) {
                line = br.readLine();
                firstIndex = line.indexOf(">") + 1;
                lastIndex = line.indexOf("</", lineIndex);
                Group group = new Group(line.substring(firstIndex, lastIndex));
                line = br.readLine();
                while (!line.startsWith("</Group>", line.indexOf("<"))) {
                    if (line.startsWith(CIRCLE_NODE, line.indexOf("<"))) {
                        line = br.readLine();
                        firstIndex = line.indexOf(">") + 1;
                        lastIndex = line.indexOf("</", firstIndex);
                        String stringRadius = line.substring(firstIndex, lastIndex);
                        double radius = Double.parseDouble(stringRadius);
                        group.addShape(new Circle(radius));
                        line = br.readLine();
                    }

                    if (line.startsWith(TRIANGLE_NODE, line.indexOf("<"))) {
                        line = br.readLine();

                        firstIndex = line.indexOf(">") + 1;
                        lastIndex = line.indexOf("</");
                        String stringASide = line.substring(firstIndex, lastIndex);
                        double aSide = Double.parseDouble(stringASide);
                        line = br.readLine();

                        firstIndex = line.indexOf(">") + 1;
                        lastIndex = line.indexOf("</");
                        String stringBSide = line.substring(firstIndex, lastIndex);
                        double bSide = Double.parseDouble(stringBSide);
                        line = br.readLine();

                        firstIndex = line.indexOf(">") + 1;
                        lastIndex = line.indexOf("</");
                        String stringCSide = line.substring(firstIndex, lastIndex);
                        double cSide = Double.parseDouble(stringCSide);
                        line = br.readLine();

                        group.addShape(new Triangle(aSide, bSide, cSide));
                        line = br.readLine();
                    }

                    if (line.startsWith(SQUARE_NODE, line.indexOf("<"))) {
                        line = br.readLine();
                        firstIndex = line.indexOf(">") + 1;
                        lastIndex = line.indexOf("</");
                        String stringSide = line.substring(firstIndex, lastIndex);
                        double side = Double.parseDouble(stringSide);
                        group.addShape(new Square(side));
                    }
                    line = br.readLine();
                }
            }
            line = br.readLine();
        }
        br.close();
    }
}
