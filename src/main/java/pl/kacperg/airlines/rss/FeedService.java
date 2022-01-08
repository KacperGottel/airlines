package pl.kacperg.airlines.rss;

import java.util.List;

public interface FeedService {
    List<FeedMessage> getOnly2FeedMessages(Feed feed);
    String getFeedPubDate(Feed feed);
}
