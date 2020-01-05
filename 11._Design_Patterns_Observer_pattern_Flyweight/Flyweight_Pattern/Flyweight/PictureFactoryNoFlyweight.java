package Flyweight_Pattern.Flyweight;

public class PictureFactoryNoFlyweight {
    public static Picture factory(String card) {
        switch (card) {
            case "jack":
                return new Jack();
            case "queen":
                return new Queen();
            case "king":
                return new King();
        }
        return null;
    }
}
