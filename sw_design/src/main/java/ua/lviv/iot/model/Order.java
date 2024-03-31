package ua.lviv.iot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "ticket", fetch = FetchType.LAZY)
    private Ticket ticket;

    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Basic
    @Column(name = "order_date", nullable = false)
    private String orderDate;
    public Order(User user, Ticket ticket, Integer quantity, String orderDate) {
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
    public String[] toCsvFormat() {
        return new String[]{ "ORDER", String.valueOf(this.quantity), this.orderDate};
    }
}
