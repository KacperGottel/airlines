package pl.kacperg.airlines.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String loginGet() {
        return "home/login";
    }

    @RequestMapping("/404")
    public String deniedLogin() {
        return "errors/404";
    }

    @RequestMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "home/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult bindingResult, Model model, @RequestParam("confirm") String confirm) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getModel());
            model.addAttribute("user", new User());
            return "home/register";
        }
        if (user.getPassword().equals(confirm)) {
            userService.saveUser(user);
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("confirmerror", "Confirmation Error");
            return "home/register";
        }

        return "redirect:/";
    }

    @ModelAttribute
    public void addAttributes(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("currentuser", currentUser);
    }
}
