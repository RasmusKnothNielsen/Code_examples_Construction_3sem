package GenericsExample;

class Test<T, U> {

    T object1;
    U object2;

    Test(T object1, U object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    void print() {
        System.out.println("Object 1: " + object1);
        System.out.println("Object 2: " + object2);
    }

}
