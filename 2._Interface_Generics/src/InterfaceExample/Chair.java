package InterfaceExample;

public class Chair implements Furniture {

    private int peopleSeated = 0;
    int amountOfPillows = 0;

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
