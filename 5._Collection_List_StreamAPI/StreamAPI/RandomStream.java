package StreamAPI;

import org.w3c.dom.ls.LSOutput;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

public class RandomStream {

    public static void main(String[] args) {

        Random random = new Random();
        Date date = new Date();

        // Continuous flow of random
        //random.ints().forEach(System.out::println);

        // Limited number of random
        System.out.println("Stream:");
        random.ints().limit(100).forEach(System.out::println);





    }
}
