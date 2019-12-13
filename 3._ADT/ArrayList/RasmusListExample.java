package ArrayList;

public class RasmusListExample {

    public static void main(String[] args) {

        RasmusList<String> stringArray = new RasmusList<>();

        stringArray.add("Programming");
        stringArray.add("is");
        stringArray.add("fun");

        RasmusList<String> newStringArray = new RasmusList<>();
        newStringArray = stringArray.clone();

        System.out.println("String Array: " + stringArray);

        System.out.println("New String Array: " + newStringArray);


    }
}
