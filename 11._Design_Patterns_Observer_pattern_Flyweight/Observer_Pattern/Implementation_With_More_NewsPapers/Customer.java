package Observer_Pattern.Implementation_With_More_NewsPapers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Observer Object
public class Customer {

    // HashMap to hold the newspaper and the news.
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

    public String getNews() {
        String allNews = "";
        Iterator iterator = news.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            allNews += "Avis: " + pair.getKey().toString() + "\nNyhed: " + pair.getValue() + "\n";
        }
        allNews += "\n";
        return allNews;
    }

}
