package inheritance;

public class MainInheritance {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        Car car = new Car();

        System.out.print("\nStarting vehicle: ");
        vehicle.start();

        System.out.print("Stopping vehicle: ");
        vehicle.stop();


        // Overriding method in Vehicle
        System.out.print("\nStarting car: ");
        car.start();

        // Inherited from Vehicle
        System.out.print("Stopping car: ");
        car.stop();

        // New method
        System.out.print("Opening window: ");
        car.openWindow();

    }
}
