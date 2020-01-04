package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismMain {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal());
        animalList.add(new Goat());

        animalList.forEach(Animal::makeSound);
    }

}
