package Flyweight_Pattern.Flyweight;

import java.util.HashMap;

public class PictureFactoryFlyweight {
    static HashMap<String, Picture> pictures = new HashMap<>();

    public static Picture factory(String card) {
        Picture picture;
        picture = pictures.get(card);
        if (picture == null) {
            switch (card) {
                case "jack":
                    picture = new Jack();
                    break;
                case "queen":
                    picture = new Queen();
                    break;
                case "king":
                    picture = new King();
            }
            if(picture!=null)
                pictures.put(card,picture);
        }
        return picture;
    }
}
