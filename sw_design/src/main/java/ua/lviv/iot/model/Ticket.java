package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Basic
    @Column(name = "ticket_type")
    private String ticketType;

    @Basic
    @Column(name = "price")
    private Double price;

    public Ticket(Event event, String ticketType, Double price) {
        this.ticketType = ticketType;
        this.price = price;
    }
    public String[] toCsvFormat() {
        return new String[]{ "TICKET", this.ticketType, String.valueOf(this.price)};
    }
}
