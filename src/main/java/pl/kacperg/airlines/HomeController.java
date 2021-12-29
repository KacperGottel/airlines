package pl.kacperg.airlines;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperg.airlines.rss.Feed;
import pl.kacperg.airlines.rss.FeedMessage;
import pl.kacperg.airlines.rss.RssFeedParser;

import java.io.IOException;
import java.net.URL;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping(value = "")
    public String home(Model model) throws IOException {
        RssFeedParser parser = new RssFeedParser("https://tvn24.pl/polska.xml");
        Feed feed = parser.readFeed();
        model.addAttribute("feed", feed);
        return "home/home";
    }
}
