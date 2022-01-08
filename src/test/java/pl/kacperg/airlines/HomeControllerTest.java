package pl.kacperg.airlines;

import org.junit.jupiter.api.Test;
import pl.kacperg.airlines.rss.Feed;
import pl.kacperg.airlines.rss.RssFeedParser;

class HomeControllerTest {

    @Test
    public void testFeed() {
        RssFeedParser parser = new RssFeedParser("https://www.polsatnews.pl/rss/wszystkie.xml");
        Feed feed = parser.readFeed();
        System.out.println(feed.getPubDate());
    }
}