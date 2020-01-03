package Decorator;

// The decorator class itself is abstract as it would be without meaning to instantiate.
// Since this class is abstract it does not need to implement the methods from the Pizza interface.
abstract class ToppingDecorator implements Pizza {

    Pizza pizza;

    ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

}
