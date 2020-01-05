package Observer_Pattern.Build_From_Scratch;

// Observer Object
public class Customer {

    private String news;

    // Get the state from the newspaper
    public void update(String news) {
        this.news = news;
    }

    // Return news saved in Customer
    public String getNews() {
        return news;
    }

}
