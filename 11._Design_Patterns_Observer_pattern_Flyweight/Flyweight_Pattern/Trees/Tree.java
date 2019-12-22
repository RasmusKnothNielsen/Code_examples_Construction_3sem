package Flyweight_Pattern.Trees;

import java.awt.*;

// Contains state unique for each tree
public class Tree {

    private int x;
    private int y;
    private TreeType type;

    public Tree(int height, int width, TreeType type) {
        this.x = height;
        this.y = width;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }

}
