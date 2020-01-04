package Observer_Pattern.Implementation_With_More_NewsPapers;

import java.util.HashMap;

// Observer Object
public class Customer {

    // Hashmap to hold the newspaper and the news.
    // Only one news pr. newspaper, in this implementation.
    private HashMap<NewsPaper, String> news = new HashMap<>();

    // Get the state from the newspaper
    public void update(NewsPaper newsPaper, String news) {
        this.news.put(newsPaper, news);
    }

    // Return news from the specific newspaper
    public String getNews(NewsPaper newsPaper) {
        return news.get(newsPaper);
    }

}
