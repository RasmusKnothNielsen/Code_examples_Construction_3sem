package Observer_Pattern.Implements_Observer;

public class Example {

    public static void main(String[] args) {

        // Create one instance of a NewsPaper (Observable)
        NewsPaper observable = new NewsPaper();

        // Create four instances of Customers
        Customer observer1 = new Customer();
        Customer observer2 = new Customer();
        Customer observer3 = new Customer();
        Customer observer4 = new Customer();

        // Add these customers to the newspapers subscription
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);
        observable.addObserver(observer4);

        // Change the state in all observers
        observable.setNews("Breaking News: New Tesla released!");

        // Print out the state from all observers
        System.out.println(observer1.getNews());
        System.out.println(observer2.getNews());
        System.out.println(observer3.getNews());
        System.out.println(observer4.getNews());



    }

}
