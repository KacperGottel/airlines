package pl.kacperg.airlines.airlinesapi.flights;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperg.airlines.rss.FeedService;

@Controller
@Slf4j
public class FlightController {

    private  final FlightService flightservice;
    private  final FeedService feedService;

    public FlightController(FlightService flightservice, FeedService feedService) {
        this.flightservice = flightservice;
        this.feedService = feedService;
    }

    @RequestMapping(value = "flight/{flightnumber}")
    public String getFlightDetails(@PathVariable String flightnumber, Model model){
        model.addAttribute("datum", flightservice.getDatumByFlightNumber(flightnumber));
        return "flight/details";
    }
}
