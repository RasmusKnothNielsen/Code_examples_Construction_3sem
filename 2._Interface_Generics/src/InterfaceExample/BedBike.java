package InterfaceExample;

public class BedBike implements Furniture, Vehicle {

    int peopleSeated = 0;
    int amountOfPillows = 0;
    int speed = 0;

    @Override
    public void speedUp(int speedIncrease) {
        speed += speedIncrease;
    }

    @Override
    public void applyBrakes(int speedDecrease) {
        speed -= speedDecrease;
    }

    @Override
    public void sitOn() {
        peopleSeated++;
    }

    @Override
    public void getUp() {
        peopleSeated--;
    }

    @Override
    public int peopleSeated() {
        return peopleSeated;
    }

    @Override
    public void addPillows(int amount) {
        amountOfPillows += amount;
    }
}
