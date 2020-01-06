package Flyweight_Pattern.Trees;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Used to demo the constructed code
public class Demo {

    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1_000_000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {

        Forest forest = new Forest();

        // Exit program when windows is closed.
        forest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random random = new Random();

        // For loop that plants TREES_TO_DRAW trees
        for (int i = 0; i < TREES_TO_DRAW / TREE_TYPES; i++) {

            // First type of trees that is going to be planted
            forest.plantTree(
                    random.nextInt(CANVAS_SIZE),    // Where to plant on the X axis
                    random.nextInt(CANVAS_SIZE),    // Where to plant on the Y axis
                    "Summer Oak",
                    Color.GREEN,
                    "Oak texture stub"
            );

            forest.plantTree(
                    random.nextInt(CANVAS_SIZE),    // Where to plant on the X axis
                    random.nextInt(CANVAS_SIZE),    // Where to plant on the Y axis
                    "Autumn Oak",
                    Color.ORANGE,
                    "Autumn Oak texture stub"
            );
        }

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

    }
}
