package InterfaceExample;

public class Car implements Vehicle {

    int speed = 0;

    @Override
    public void speedUp(int speedIncrease) {
        speed += speedIncrease;
    }

    @Override
    public void applyBrakes(int speedDecrease) {
        speed -= speedDecrease;
    }

}
