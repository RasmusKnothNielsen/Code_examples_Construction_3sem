package Flyweight_Pattern.Cargo;

import java.util.LinkedList;
import java.util.List;

public class  NoFlyweight {
    public static void main(String[] args) {

        List<Cargo> cargoList = new LinkedList<>();

        for(int i=0;i<1024*1024;i++){
            cargoList.add(new Cargo());
        }

    }
}
