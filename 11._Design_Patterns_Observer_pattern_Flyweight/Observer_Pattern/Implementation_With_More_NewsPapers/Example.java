package Observer_Pattern.Implementation_With_More_NewsPapers;

public class Example {

    public static void main(String[] args) {

        // Instantiate a newspaper
        NewsPaper berlingske = new NewsPaper("Berlingske");
        NewsPaper bt = new NewsPaper("BT");

        // Instantiate 4 Customers.
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();

        // Get the Customer to subscribe to Berlingske
        berlingske.subscribe(customer1);
        berlingske.subscribe(customer2);
        berlingske.subscribe(customer3);
        berlingske.subscribe(customer4);

        // Get two customers to subscribe to BT
        bt.subscribe(customer1);
        bt.subscribe(customer2);

        // Set the news
        berlingske.setNews("Dansk træning af irakiske styrker indstilles efter drab");
        bt.setNews("Tusindvis af danskere får kompensation");

        // Print out the both newspapers from Customer 1

        System.out.println("\nHer ses de nyheder som er tilgængelige for vores første kunde:");
        System.out.println(customer1.getNews(berlingske));
        System.out.println(customer1.getNews(bt));
        System.out.println();

        bt.setNews("Henrik trodser alle advarsler til danskerne");

        System.out.println("Her ses nyhederne efter BT har opdateret deres nyheder:");
        System.out.println(customer1.getNews());




    }

}
