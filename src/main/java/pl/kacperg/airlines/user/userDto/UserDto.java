package pl.kacperg.airlines.user.userDto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@Component
public class UserDto {
    @NotNull(message = "Incorrect username")
    @Size(min=2, max=30, message = "2-30 chars")
    private String username;
    @Size(min = 1, message = "min 1")
    @NotEmpty(message = "Incorrect password")
    private String password;
    @NotEmpty(message = "Incorrect name")
    private String firstName;
    @NotEmpty(message = "Incorrect surname")
    private String lastName;
    @NotNull(message = "Incorrect email")
    @Email(message = "Incorrect email")
    private String email;
    @NotNull(message = "Incorrect age")
    @Min(value = 15, message = "min 15")
    @Max(value = 120, message = "max 120")
    private Integer age;
}
