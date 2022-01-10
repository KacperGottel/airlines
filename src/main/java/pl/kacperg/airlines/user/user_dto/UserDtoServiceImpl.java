package pl.kacperg.airlines.user.user_dto;

import org.springframework.stereotype.Service;
import pl.kacperg.airlines.user.User;
import pl.kacperg.airlines.user.UserRepository;

@Service
public class UserDtoServiceImpl implements UserServiceDto{

    private final UserRepository userRepository;

    public UserDtoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserDto(Long id) {
        UserDto userDto = new UserDto();
        User user = userRepository.getById(id);
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }
}
