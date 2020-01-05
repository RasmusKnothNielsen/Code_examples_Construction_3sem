package Flyweight_Pattern.Flyweight;

public class Card {
    String color;
    Picture picture;

    public Card(String value, String color){
        this.color=color;
        this.picture=PictureFactoryNoFlyweight.factory(value);
        //this.picture=PictureFactoryFlyweight.factory(value);
    }
}
