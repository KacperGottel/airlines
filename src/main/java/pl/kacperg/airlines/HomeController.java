package pl.kacperg.airlines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kacperg.airlines.airlinesapi.FlightsData;
import pl.kacperg.airlines.rss.Feed;

import pl.kacperg.airlines.rss.FeedMessage;
import pl.kacperg.airlines.rss.FeedService;
import pl.kacperg.airlines.rss.RssFeedParser;

import java.util.List;


@Controller
@Slf4j
public class HomeController {

    private final FlightsData flightsData;

    private final FeedService feedService;

    public HomeController(FlightsData flightsData, FeedService feedService) {
        this.flightsData = flightsData;
        this.feedService = feedService;
    }

    @RequestMapping(value = "")
    public String home(Model model) {
//        NEWS RSS
        RssFeedParser parser = new RssFeedParser("https://www.polsatnews.pl/rss/wszystkie.xml");
        Feed feed = parser.readFeed();

        String feedPubDate = feedService.getFeedPubDate(feed);

        List<FeedMessage> feedlist = feedService.getOnly2FeedMessages(feed);

        model.addAttribute("feedList", feedlist);
        model.addAttribute("feed", feed);
        model.addAttribute("feedPubDate", feedPubDate);
//        Avionstack Api Flights
        model.addAttribute("flights", flightsData.getAllFlights());
        return "home/home";
    }

}
