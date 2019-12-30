package Observer_Pattern.Build_From_Scratch;

public class Example {

    public static void main(String[] args) {

        // Instantiate a newspaper
        NewsPaper berlingske = new NewsPaper();

        // Instantiate 4 Customers.
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();

        // Get the Customer to subscribe to the newspaper
        berlingske.subscribe(customer1);
        berlingske.subscribe(customer2);
        berlingske.subscribe(customer3);
        berlingske.subscribe(customer4);

        // Set the news on berlingske
        berlingske.setNews("Breaking News: Berlingske understøtter nu Java!");

        // Check if the state in customer has been changed.
        System.out.println("\nHer ses de nuværende 'tilstande' i vores Customers:");
        System.out.println("Customer 1 : " + customer1.getNews());
        System.out.println("Customer 2 : " + customer2.getNews());
        System.out.println("Customer 3 : " + customer3.getNews());
        System.out.println("Customer 4 : " + customer4.getNews() + "\n");

        // Unsubscribe customer 4
        berlingske.unsubscribe(customer4);

        // Change the news on berlingske
        berlingske.setNews("Breaking News: Prins Joachim er med i Vild med Dans!");

        // Check if all other than customer4 has been updated
        System.out.println("Her ses de opdaterede 'tilstande', efter Customer4 har opsagt sit abonnement:");
        System.out.println("Customer 1 : " + customer1.getNews());
        System.out.println("Customer 2 : " + customer2.getNews());
        System.out.println("Customer 3 : " + customer3.getNews());
        System.out.println("Customer 4 : " + customer4.getNews() + "\n");

        // Create a new News Paper
        NewsPaper bt = new NewsPaper();

        // Tell the News paper, that Customer 4 wants to subscribe
        bt.subscribe(customer4);

        // Set the news on BT News Paper
        bt.setNews("Breaking News: Naboerne gik i chok, du gætter aldrig hvad der skete næst!");

        // Check if Customer 4 got the updated news from BT as the only one.
        System.out.println("Her ses de opdaterede 'tilstande' efter Customer4 har abonnemeret til BT:");
        System.out.println("Customer 1 : " + customer1.getNews());
        System.out.println("Customer 2 : " + customer2.getNews());
        System.out.println("Customer 3 : " + customer3.getNews());
        System.out.println("Customer 4 : " + customer4.getNews());
    }
}
