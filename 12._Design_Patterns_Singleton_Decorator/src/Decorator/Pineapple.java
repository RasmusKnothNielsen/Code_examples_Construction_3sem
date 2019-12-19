package Decorator;

// All toppings are classes extending the ToppingDecorator to ensure compatibility.
public class Pineapple extends ToppingDecorator {

    // All toppings requires a Pizza object to build upon.
    Pineapple(Pizza pizza) { super(pizza); }

    // Implementing the methods from the pizza interface with topping-specific values
    // Toppings get the values the pizza already had, and add it's own values on top.
    @Override
    public String getDescription() { return pizza.getDescription() + ", Pineapple"; }

    @Override
    public int getCost() { return pizza.getCost() + 4_00; }

}