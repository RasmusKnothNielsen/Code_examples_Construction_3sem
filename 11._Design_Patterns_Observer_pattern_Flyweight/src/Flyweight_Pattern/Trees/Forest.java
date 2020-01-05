package Flyweight_Pattern.Trees;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Forest that holds the trees, which we draw
public class Forest extends JFrame {

    // ArrayList that holds Trees
    private List<Tree> trees = new ArrayList<>();

    // Method that creates a tree and saves it to the above ArrayList of trees
    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    // Method used for drawing the trees
    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }

}
