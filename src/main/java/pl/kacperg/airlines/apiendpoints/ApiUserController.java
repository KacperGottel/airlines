package pl.kacperg.airlines.apiendpoints;

import org.springframework.web.bind.annotation.*;
import pl.kacperg.airlines.airlinesapi.flights.FlightService;
import pl.kacperg.airlines.airlinesapi.models.Datum;
import pl.kacperg.airlines.airlinesapi.models.Example;
import pl.kacperg.airlines.user.User;
import pl.kacperg.airlines.user.UserRepository;
import pl.kacperg.airlines.user.UserService;
import pl.kacperg.airlines.user.tickets.Ticket;
import pl.kacperg.airlines.user.tickets.TicketRepository;
import pl.kacperg.airlines.user.user_dto.UserDto;

import java.util.List;

@RestController
public class ApiUserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final TicketRepository ticketRepository;
    private final FlightService flightService;

    public ApiUserController(UserRepository userRepository, UserService userService, TicketRepository ticketRepository, FlightService flightService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
    }

    @GetMapping("/api/user/{userID}")
    @ResponseBody
    public User getUserById(@PathVariable Long userID){
        return userRepository.getById(userID);
    }

    @PostMapping("/api/user")
    @ResponseBody
    public String create(@RequestBody UserDto userDto){
        String msg;
        if (userDto != null) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userService.saveUser(user);
            msg = "saved, click email link";
        } else {
            msg = "error";
        }
        return msg;
    }
    @PutMapping("/api/user/{userID}")
    @ResponseBody
    public String update(@PathVariable Long userID, @RequestBody UserDto userDto){
        String msg;

        if (userDto != null) {
            User user = userRepository.getById(userID);
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            userRepository.save(user);
            msg = "updated";
        } else {
            msg = "error";
        }
        return msg;
    }
    @GetMapping("/api/user/{userID}/ticket")
    @ResponseBody
    public List<Ticket> getAllTicketsUserById(@PathVariable Long userID){
        return userRepository.getById(userID).getTickets();
    }
    @GetMapping("/api/ticket/{ticketID}")
    @ResponseBody
    public Ticket getAllTicketsUserById(@PathVariable Long userID, @PathVariable Long ticketID){
        return ticketRepository.getById(ticketID);
    }
    @GetMapping("/api/flight")
    @ResponseBody
    public Example getFlightList(){
        return flightService.getAllFlights();
    }
    @GetMapping("/api/flight/{number}")
    @ResponseBody
    public Datum getFlight(@PathVariable String number){
        return flightService.getDatumByFlightNumber(number);
    }

}
