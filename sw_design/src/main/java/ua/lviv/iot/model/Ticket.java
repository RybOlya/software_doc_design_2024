package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jeasy.random.EasyRandom;
import ua.lviv.iot.model.Event;

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
        this.event = event;
        this.ticketType = ticketType;
        this.price = price;
    }

    public String[] toCsvFormat() {
        Integer eventId = generateRandomId();
        return new String[]{
                "TICKET",
                eventId.toString(),
                this.ticketType,
                this.price.toString()
        };
    }

    private Integer generateRandomId() {
        EasyRandom generator = new EasyRandom();
        generator.setSeed(System.nanoTime());
        return generator.nextInt(1, 201);
    }
}
