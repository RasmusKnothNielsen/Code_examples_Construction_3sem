package Decorator;

// All toppings are classes extending the ToppingDecorator to ensure compatibility.
public class TomatoSauce extends ToppingDecorator {

    // All toppings requires a Pizza object to build upon.
    TomatoSauce(Pizza pizza) {
        super(pizza);
    }

    // Implementing the methods from the pizza interface with topping-specific values
    // Toppings get the values the pizza already had, and add it's own values on top.
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Tomato Sauce";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 1_50;
    }


}
