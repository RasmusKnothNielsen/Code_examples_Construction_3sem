package Interface;

import java.util.Set;

// Class made to determine what a given object is
// <T> is the syntax to make a class generic, with the type "T".
public class TypeTester<T> {

    // Static Method that takes an object and determins what kind of object it is.
    public static<T> String typeCheck(T type) {
        if (type instanceof Integer) {
            return "Integer";
        } else if (type instanceof String) {
            return "String";
        } else if (type instanceof Boolean) {
            return "Boolean";
        } else if (type instanceof Long) {
            return "Long";
        } else if (type instanceof Float) {
            return "Float";
        } else if (type instanceof Double) {
            return "Double";
        } else if (type instanceof Set) {
            return "Set";
        }

        return "Object";






    }
}
