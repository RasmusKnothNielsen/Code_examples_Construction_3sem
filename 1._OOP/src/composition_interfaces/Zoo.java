package composition_interfaces;

public class Zoo {

    // The Zoo is composed of different objects
    Tiger tiger = new Tiger();
    Monkey monkey = new Monkey();

    public void makeSound() {
        System.out.println("The Zoo can be heard from far away");
    }

}
