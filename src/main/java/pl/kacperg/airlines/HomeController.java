package pl.kacperg.airlines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kacperg.airlines.airlinesapi.flights.FlightService;
import pl.kacperg.airlines.airlinesapi.models.Airline;
import pl.kacperg.airlines.airlinesapi.models.Arrival;
import pl.kacperg.airlines.airlinesapi.models.Departure;
import pl.kacperg.airlines.airlinesapi.models.Example;
import pl.kacperg.airlines.exchange.ExchangeService;
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
    private final ExchangeService exchangeService;

    public HomeController(FlightService flightService, FeedService feedService, ExchangeService exchangeService) {
        this.flightService = flightService;
        this.feedService = feedService;
        this.exchangeService = exchangeService;
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

    @PostMapping(value = "")
    public String homePost(Model model,
                           @RequestParam("departureIcao") String departureIcao,
                           @RequestParam("arrivalIcao") String arrivalIcao,
                           @RequestParam("date") String date,
                           @RequestParam("number") String number,
                           @RequestParam("airline") String airline) {
        model.addAttribute("flights", flightService.searchFlight(departureIcao, arrivalIcao, date, number, airline));
        return "flight/search";
    }

    @PostMapping(value = "/exchange")
    public String exchange(Model model, @RequestParam("currency") String currency, @RequestParam("amount") Double amount) {
        model.addAttribute("result", exchangeService.exchange(currency, amount));
        log.info("result" + exchangeService.exchange(currency, amount));
        return "home/home";
    }

}
