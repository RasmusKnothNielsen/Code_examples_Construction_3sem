package Observer_Pattern.Implementation_With_More_NewsPapers;

import java.util.ArrayList;
import java.util.List;

// Observable Object
public class NewsPaper {

    private List<Customer> customers = new ArrayList<>();
    private String news;
    private String name;

    public NewsPaper(String name) {
        this.name = name;
    }

    public String getNews() {
        return news;
    }

    // Set the news in the newspaper, and notify all subscribers
    public void setNews(String news) {
        this.news = news;
        notifyAllCustomers();
    }

    // Add Customer as a subscriber
    public boolean subscribe(Customer customer) {
        return customers.add(customer);
    }

    // Remove Customer as a subscriber
    public boolean unsubscribe(Customer customer) {
        return customers.remove(customer);
    }

    // Notify all users with the new news (State)
    public void notifyAllCustomers() {
        for (Customer customer : customers) {
            customer.update(this, news);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
