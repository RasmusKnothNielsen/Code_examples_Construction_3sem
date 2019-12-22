package Observer_Pattern.Build_From_Scratch;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper {

    private List<Customer> customers = new ArrayList<>();
    private String news;

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
            customer.update(news);
        }
    }

}
