package polymorphism;

public class PolymorphismMain {

    public static void main(String[] args) {

        Animal firstAnimal = new Animal();
        Animal secondAnimal = new Goat();

        firstAnimal.makeSound();
        secondAnimal.makeSound();
    }

}
