package composition_interfaces;

public class CompositionMain {

    public static void main(String[] args) {

        Zoo zoo = new Zoo();

        System.out.println();
        zoo.makeSound();
        System.out.println();

        zoo.monkey.makeSound();
        zoo.tiger.makeSound();
    }
}
