package pl.kacperg.airlines.user.tickets;

import lombok.Data;
import pl.kacperg.airlines.user.User;

import javax.persistence.*;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer flightNumber;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
