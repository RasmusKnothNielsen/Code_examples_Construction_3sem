package Interface.InterfaceGenerics;

public class LongProducer implements MyProducer<Long> {

    @Override
    public Long produce() {
        return 10L;
    }

}
