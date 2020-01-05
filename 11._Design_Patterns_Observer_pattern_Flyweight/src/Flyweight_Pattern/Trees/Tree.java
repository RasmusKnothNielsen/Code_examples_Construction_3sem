package Flyweight_Pattern.Trees;

import java.awt.*;

// Contains state unique for each tree
// Also called Extrinsic state
public class Tree {

    // Fields relevant to each Tree
    private int x;
    private int y;
    private TreeType type;

    // Constructor
    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // Method used for drawing the tree
    public void draw(Graphics g) {
        type.draw(g, x, y);
    }

}
