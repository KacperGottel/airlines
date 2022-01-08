package pl.kacperg.airlines.rss;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class FeedServiceImplTest {

    @Test
    void setDateFormat() {
        String feedDate = "Wed, 29 Dec 2021 19:18:15 +0100";
        String s = feedDate.replaceFirst("\\+\\d*","");
        System.out.println(s);


    }
}