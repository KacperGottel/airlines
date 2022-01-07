package pl.kacperg.airlines.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.kacperg.airlines.airlinesapi.flights.FlightService;
import pl.kacperg.airlines.airlinesapi.models.Datum;
import pl.kacperg.airlines.upload.FileService;
import pl.kacperg.airlines.user.tickets.TicketRepository;
import pl.kacperg.airlines.user.userDto.UserDto;
import pl.kacperg.airlines.user.userDto.UserServiceDto;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;

@Controller
@Slf4j
public class UserController {

    private final FileService fileService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserServiceDto userServiceDto;
    private final TicketRepository ticketRepository;
    private final FlightService flightService;

    public UserController(FileService fileService, UserService userService, UserRepository userRepository,
                          UserServiceDto userServiceDto, TicketRepository ticketRepository, FlightService flightService) {
        this.fileService = fileService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.userServiceDto = userServiceDto;
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
    }


    @RequestMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "home/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") @Valid UserDto userDto,
                               BindingResult bindingResult, Model model, @RequestParam("confirm") String confirm) {

        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult);
//            model.addAttribute("user", new UserDto());
            return "home/register";
        }
        if (userDto.getPassword().equals(confirm)) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setAge(userDto.getAge());
            userService.saveUser(user);
        } else {
            model.addAttribute("user", new UserDto());
            model.addAttribute("confirmerror", "Incorrect password confirm");
            return "home/register";
        }

        return "redirect:/";
    }

    @ModelAttribute
    public void addAttributes(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentuser", currentUser);
    }

    @RequestMapping("/user/{id}")
    public String userSettingsForm(Model model, @PathVariable Long id) {
        UserDto userDto = userServiceDto.getUserDto(id);
        model.addAttribute("user", userDto);
        return "home/settings";
    }

    @PostMapping("/user/{id}")
    public String userSettingsPost(@Valid UserDto userDto, BindingResult bindingResult, Model model,
                                   @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            UserDto userDtoNew = userServiceDto.getUserDto(id);
            model.addAttribute("user", userDtoNew);
            return "home/settings";
        }
        User userById = userRepository.getById(id);
        userById.setUsername(userDto.getUsername());
        userById.setPassword(userDto.getPassword());
        userById.setEmail(userDto.getEmail());
        userById.setFirstName(userDto.getFirstName());
        userById.setLastName(userDto.getLastName());
        userService.saveUser(userById);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/{id}/tickets")
    public String userTickets(@PathVariable Long id, Model model) {
        model.addAttribute("tickets", ticketRepository.findAllByUser_Id(id));
        return "home/tickets";
    }

    @RequestMapping(value = "/user/{userID}/book/{flightNO}")
    public String bookTicket(@PathVariable Long userID, @PathVariable Integer flightNO, Model model) {
        UserDto userDto = userServiceDto.getUserDto(userID);
        Datum datum = flightService.getDatumByFlightNumber(String.valueOf(flightNO));
        model.addAttribute("userDto", userDto);
        model.addAttribute("datum", datum);
        return "home/booking";
    }

    @PostMapping(value = "/user/{userId}/uploadFile")
    public String submit(@RequestParam("file") MultipartFile file, Model model, @PathVariable Long userId) {
        User user = userRepository.getById(userId);
        File savedFile = fileService.uploadFile(file);
        user.setCovidCertificate(savedFile.getAbsolutePath());
        userRepository.save(user);
        model.addAttribute("file", file);
        return "home/filedetails";
    }

}
