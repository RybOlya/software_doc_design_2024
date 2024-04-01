package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jeasy.random.EasyRandom;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order_table")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Basic
    @Column(name = "order_date", nullable = false)
    private String orderDate;

    public Order(User user, Ticket ticket, Integer quantity, String orderDate) {
        this.user = user;
        this.ticket = ticket;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    public String[] toCsvFormat() {
        Integer userId = generateRandomId();
        Integer ticketId = generateRandomId();

        return new String[]{
                "ORDER",
                userId.toString(),
                ticketId.toString(),
                this.quantity.toString(),
                this.orderDate
        };
    }
    private Integer generateRandomId() {
        EasyRandom generator = new EasyRandom();
        generator.setSeed(System.nanoTime());
        return generator.nextInt(1, 201);
    }
}
