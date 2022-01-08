package pl.kacperg.airlines.apiendpoints;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kacperg.airlines.user.User;
import pl.kacperg.airlines.user.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DownloadControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
     void getUserById(){
        Optional<User> usr = userRepository.findById(5L);
        System.out.println(usr.orElse(usr.get()));
    }
}