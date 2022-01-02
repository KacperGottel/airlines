package pl.kacperg.airlines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kacperg.airlines.airlinesapi.*;
import pl.kacperg.airlines.airlinesapi.flights.FlightService;
import pl.kacperg.airlines.rss.Feed;

import pl.kacperg.airlines.rss.FeedMessage;
import pl.kacperg.airlines.rss.FeedService;
import pl.kacperg.airlines.rss.RssFeedParser;

import java.util.List;
import java.util.Set;


@Controller
@Slf4j
public class HomeController {


    private final FlightService flightService;
    private final FeedService feedService;


    public HomeController(FlightService flightService, FeedService feedService) {
        this.flightService = flightService;
        this.feedService = feedService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
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
//        Form DeparturesList
        Set<Departure> departuresList = flightService.getDeparturesList(allFlights);
        model.addAttribute("departuresList", departuresList);
//        Form ArrivalsList
        Set<Arrival> arrivalsList = flightService.getArrivalsList(allFlights);
        model.addAttribute("arrivalsList", arrivalsList);
//        Form AirlinesList
        Set<Airline> airlinesList = flightService.getAirlinesList(allFlights);
        model.addAttribute("airlinesList", airlinesList);
//        Form NumberList
        Set<String> numbers = flightService.getFlightNumbers(allFlights);
        model.addAttribute("numbers", numbers);
        return "home/home";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String homePost(Model model,
                           @RequestParam("departureIcao") String departureIcao,
                           @RequestParam("arrivalIcao") String arrivalIcao,
                           @RequestParam("date") String date,
                           @RequestParam("number") String number,
                           @RequestParam("airline") String airline) {
        model.addAttribute("flights", flightService.searchFlight(departureIcao, arrivalIcao, date, number, airline));
        return "flight/search";
    }

}
