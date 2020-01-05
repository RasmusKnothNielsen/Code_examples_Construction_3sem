package Flyweight_Pattern.Flyweight;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
    CHANGE LINE 9 + 10 IN 'CARD' TO TURN ON/OFF FLYWEIGHT
 */

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        List<Card> cardList = new LinkedList<>();

        for (int i = 0; i < 1_000_000; i++)
            cardList.add(getRandomCard());
    }

    static Card getRandomCard() {
        String color;
        int rnd = random.nextInt(4);
        switch (rnd) {
            case 0:
                color = "spades";
                break;
            case 1:
                color = "hearts";
                break;
            case 2:
                color = "clubs";
                break;
            default:
                color = "diamonds";
        }

        String value;
        rnd = random.nextInt(3);
        switch (rnd) {
            case 0:
                value = "jack";
                break;
            case 1:
                value = "queen";
                break;
            default:
                value = "king";
        }

        return new Card(value, color);
    }
}
