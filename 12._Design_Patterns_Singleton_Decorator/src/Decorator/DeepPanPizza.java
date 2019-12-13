package Decorator;

// One of the basic components. This class implements Pizza, but is not using the decorator.
// This class acts as a starting point to build a new pizza.
public class DeepPanPizza implements Pizza {

    // Implementing the methods from the pizza interface with values specific to this dough.
    @Override
    public String getDescription() {
        return "Deep-Pan Crust";
    }

    @Override
    public int getCost() {
        return 60_00;
    }

}
