package pl.kacperg.airlines.apiendpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kacperg.airlines.rss.Feed;
import pl.kacperg.airlines.rss.RssFeedParser;

@RestController
public class RssController {

    @RequestMapping(value = "api/rss", method = RequestMethod.GET)
    public String home() throws JsonProcessingException {
        RssFeedParser parser = new RssFeedParser("https://www.polsatnews.pl/rss/wszystkie.xml");
        Feed feed = parser.readFeed();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(feed);
    }
}
