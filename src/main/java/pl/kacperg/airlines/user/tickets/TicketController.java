package pl.kacperg.airlines.user.tickets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperg.airlines.airlinesapi.flights.FlightService;
import pl.kacperg.airlines.airlinesapi.models.Datum;
import pl.kacperg.airlines.user.CurrentUser;

@Controller
@Slf4j
public class TicketController {
    private final TicketRepository ticketRepository;
    private final FlightService flightService;

    public TicketController(TicketRepository ticketRepository, FlightService flightService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
    }
    @ModelAttribute
    public void addAttributes(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentuser", currentUser);
    }

    @RequestMapping(value = "/ticket/{ticketId}")
    public String getTicketFlightDetails(@PathVariable Long ticketId, Model model){
        Ticket ticket = ticketRepository.getById(ticketId);
        Integer flightNumber = ticket.getFlightNumber();
        Datum datum = flightService.getDatumByFlightNumber(String.valueOf(flightNumber));
        model.addAttribute("datum", datum);
        return "flight/details";
    }
    @RequestMapping(value = "/ticket/{ticketId}/delete")
    public String deleteTicket(@PathVariable Long ticketId, Model model){
        Ticket ticket = ticketRepository.getById(ticketId);
        Long userId = ticket.getUser().getId();
        ticketRepository.delete(ticket);
        return String.format("redirect:/user/%s/tickets",userId);
    }
}
