package pl.kacperg.airlines.user;

import lombok.Data;
import pl.kacperg.airlines.user.role.Role;
import pl.kacperg.airlines.user.tickets.Ticket;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @NotBlank(message = "Empty username")
    private String username;
    @Email(message = "Incorrect email")
    private String email;
    private String firstName;
    private String lastName;
    @NotBlank(message = "Empty password")
    private String password;
    private boolean enabled;
    @Min(15)
    private Integer age;
    @OneToMany(mappedBy="user")
    private List<Ticket> tickets;
    @ManyToOne
    private Role role;
}
