package Interface.InterfaceGenerics;

public class StringProducer implements MyProducer<String> {

    @Override
    public String produce() {
        return "Produced this String!";
    }

}
