package pl.kacperg.airlines.user;


public interface UserService {

    User findByUsername(String username);
    User findByUserNameEnable(String name);
    void saveUser(User user);
    User findUserByEmail(String email);

}
