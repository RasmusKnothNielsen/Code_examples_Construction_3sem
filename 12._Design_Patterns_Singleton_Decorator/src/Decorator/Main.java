package Decorator;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        // Creating a new pizza. Starting with a plain pizza, and then using the decorator pattern to add toppings.
        // Because of the way the layering works calling hawaiiPizza.getDescription()
        // returns the accumulated description of all the ingredients.
        // Likewise with the cost.
        Pizza hawaiiPizza = new Pineapple(new Ham(new Cheese(new TomatoSauce(new PlainPizza()))));
        System.out.println("Ingredients: " + hawaiiPizza.getDescription());
        System.out.println("Price: " + formatPrice(hawaiiPizza.getCost()) + " DKK\n");


        // Having the choice of 2 types of dough, just 4 different toppings and a max of 5 toppings per pizza results in:
        // 2 * 4^5 = 2048 different pizzas.

        // The advantage of using the decorator pattern over inheritance is that all combinations of decorations
        // are supported without needing a specific class for it.
        Pizza cheeseSplosion = new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new Cheese(new DeepPanPizza())))))))))));
        System.out.println("Ingredients: " + cheeseSplosion.getDescription());
        System.out.println("Price: " + formatPrice(cheeseSplosion.getCost()) + " DKK\n");

    }

    // Formatting only - not important
    private static String formatPrice(int price) {
        String p = String.valueOf(price);
        p = p.substring(0,p.length()-2) + "," + p.substring(p.length()-2);
        return p;
    }

}