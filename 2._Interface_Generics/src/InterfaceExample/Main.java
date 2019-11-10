package InterfaceExample;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        Chair chair = new Chair();
        BedBike bedBike = new BedBike();

        System.out.println("Car can move: " + car.canMove);
        car.speedUp(200);
        System.out.println("Car speed: " + car.speed);

        chair.sitOn();
        chair.sitOn();
        chair.getUp();
        chair.addPillows(3);
        System.out.println("\nPeople in chair: " + chair.peopleSeated());
        System.out.println("Pillows in chair: " + chair.amountOfPillows);

        System.out.println("\nBed Bike can move: " + bedBike.canMove);
        bedBike.sitOn();
        bedBike.addPillows(2);
        bedBike.speedUp(120);
        bedBike.applyBrakes(20);
        System.out.println("People in Bed Bike: " + bedBike.peopleSeated);
        System.out.println("Pillows in Bed Bike: " + bedBike.amountOfPillows);
        System.out.println("Bed Bike speed: " + bedBike.speed);

    }

}
