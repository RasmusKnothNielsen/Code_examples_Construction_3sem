package GenericsExample;

public class Generics {

    public Object methodObject(Object object) {
        return object.toString();
    }

    public <T> T methodGenerics(T t) {
        return t.toString();
    }

}
