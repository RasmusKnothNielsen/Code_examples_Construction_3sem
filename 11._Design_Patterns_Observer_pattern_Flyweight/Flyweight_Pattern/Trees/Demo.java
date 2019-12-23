package Flyweight_Pattern.Trees;

import java.awt.*;

// Used to demo the constructed code
public class Demo {

    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1_000_000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {

        Forest forest = new Forest();

        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {

            forest.plantTree(random(0, CANVAS_SIZE), (random(0, CANVAS_SIZE)),
                    "Summer Oak", Color.GREEN, "Oak texture stub");

            forest.plantTree(random(0, CANVAS_SIZE), (random(0, CANVAS_SIZE)),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("----------------------");
        System.out.println("Memory Usage:");
        System.out.println("Tree Size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes Size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("----------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");

    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1 ));
    }

}