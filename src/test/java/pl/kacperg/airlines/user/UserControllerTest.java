package pl.kacperg.airlines.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
class UserControllerTest {

    private final UserRepository userRepository;

    UserControllerTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void getUserAndShowHisPassword(){
        String password = userRepository.getById(5L).getPassword();
        assert(Objects.equals(password, "a"));
        System.out.println(password);
    }
}