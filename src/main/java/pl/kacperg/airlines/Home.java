package pl.kacperg.airlines;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping(value = "/")
    public String home(){
        return "home/home";
    }
}
