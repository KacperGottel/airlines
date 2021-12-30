package pl.kacperg.airlines.rss;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    @Override
    public List<FeedMessage> getOnly2FeedMessages(Feed feed) {
        FeedMessage feedMessage1 = feed.getMessages().get(0);
        FeedMessage feedMessage2 = feed.getMessages().get(1);
        List<FeedMessage> feedlist = new ArrayList<>();
        feedlist.add(feedMessage1);
        feedlist.add(feedMessage2);
        return feedlist;
    }

    @Override
    public String getFeedPubDate(Feed feed) {
        String pubDate = feed.getPubDate();
        return pubDate.replaceFirst("\\+\\d*","");
    }
}
