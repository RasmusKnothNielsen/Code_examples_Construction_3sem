package Observer_Pattern.Implements_Observer;

import java.util.Observable;

public class NewsPaper extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}