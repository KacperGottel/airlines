package pl.kacperg.airlines.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.kacperg.airlines.user.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.kacperg.airlines.user.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.kacperg.airlines.user.User getUser() {return user;}
}
