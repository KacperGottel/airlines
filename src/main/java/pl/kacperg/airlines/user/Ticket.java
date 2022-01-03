package pl.kacperg.airlines.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
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
