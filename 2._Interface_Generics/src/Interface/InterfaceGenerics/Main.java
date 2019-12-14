package Interface.InterfaceGenerics;

public class Main {

    public static void main(String[] args) {

        MyProducer<String> stringProducer = new StringProducer();
        String producedString = stringProducer.produce();
        System.out.println(producedString);

        MyProducer<Long> longProducer = new LongProducer();
        Long producedLong = longProducer.produce();
        System.out.println(producedLong);

    }

}
