package ua.lviv.iot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Basic
    @Column(name = "date", nullable = false)
    private String date;

    @Basic
    @Column(name = "venue", nullable = false)
    private String venue;

    public Event(String eventName, String eventDate, String venue) {
        this.name = eventName;
        this.date = eventDate;
        this.venue = venue;
    }
    public String[] toCsvFormat() {
        return new String[]{ "EVENT", this.name, this.date, this.venue};
    }
}
