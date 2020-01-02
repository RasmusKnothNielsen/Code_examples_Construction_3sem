package Flyweight_Pattern.Trees;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// Encapsulates complexity of flyweight creation
public class TreeFactory {

    // HashMap Collection of TreeTypes
    static Map<String, TreeType> treeTypes = new HashMap<>();

    // Method to retrieve TreeTypes from above Collection if exists.
    // If not exists, then save the new TreeType to Collection.
    public static TreeType getTreeType(String name, Color color,String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }

}
