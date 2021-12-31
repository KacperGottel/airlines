package pl.kacperg.airlines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperg.airlines.airlinesapi.Example;
import pl.kacperg.airlines.airlinesapi.FlightService;
import pl.kacperg.airlines.rss.Feed;

import pl.kacperg.airlines.rss.FeedMessage;
import pl.kacperg.airlines.rss.FeedService;
import pl.kacperg.airlines.rss.RssFeedParser;

import java.util.List;


@Controller
@Slf4j
public class HomeController {


    private final FlightService flightService;

    private final FeedService feedService;


    public HomeController(FlightService flightService, FeedService feedService) {
        this.flightService = flightService;
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
        Example allFlights = flightService.getAllFlights();
        model.addAttribute("flights", allFlights);
        return "home/home";
    }

}
