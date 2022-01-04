package pl.kacperg.airlines.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserServiceDto userServiceDto;

    public UserController(UserService userService, UserRepository userRepository, UserServiceDto userServiceDto) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userServiceDto = userServiceDto;
    }


    @RequestMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "home/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserDto userDto, BindingResult bindingResult, Model model, @RequestParam("confirm") String confirm) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getModel());
            model.addAttribute("user", new UserDto());
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
            model.addAttribute("confirmerror", "Confirmation Error");
            return "home/register";
        }

        return "redirect:/";
    }

    @ModelAttribute
    public void addAttributes(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentuser", currentUser);
    }

    @RequestMapping("/user/{id}")
    public String userSettingsForm(Model model, @PathVariable Long id){
        UserDto userDto = userServiceDto.getUserDto(id);
        model.addAttribute("user", userDto);
        return "home/settings";
    }

    @PostMapping("/user/{id}")
    public String userSettingsPost(@Valid UserDto userDto, BindingResult bindingResult, Model model, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            UserDto userDtoNew = userServiceDto.getUserDto(id);
            model.addAttribute("user", userDtoNew);
            return "home/settings";
        }
        User userbyId = userRepository.getById(id);
        userbyId.setUsername(userDto.getUsername());
        userbyId.setPassword(userDto.getPassword());
        userbyId.setEmail(userDto.getEmail());
        userbyId.setFirstName(userDto.getFirstName());
        userbyId.setLastName(userDto.getLastName());
        userService.saveUser(userbyId);
        return "redirect:/";
    }


}
