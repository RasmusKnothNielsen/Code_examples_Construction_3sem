package Flyweight_Pattern.Trees;

import java.awt.*;

// Contains state shared by several trees
// Also called Intrinsic state
public class TreeType {

    // Fields
    private String name;
    private Color color;
    private String otherTreeData;

    // Constructor
    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    // Method used for drawing the trees
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }

}
