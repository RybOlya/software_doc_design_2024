package ua.lviv.iot.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "date")
    private String date;

    @Basic
    @Column(name = "venue")
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
