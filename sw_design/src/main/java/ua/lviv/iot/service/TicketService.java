package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.repository.TicketRepository;

import java.util.List;


@Service
public class TicketService extends AbstractService<Ticket> {
    private final EventService eventService;
    @Autowired
    public TicketService(TicketRepository ticketRepository, EventService eventService) {
        super(ticketRepository);
        this.eventService = eventService;
    }

    @Override
    public Ticket mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        Integer eventid = Integer.parseInt(objectCsv[1]);
        List<Event> listev = eventService.findAll();
        Event event = eventService.getById(Integer.parseInt(objectCsv[1]));
        String ticketType = objectCsv[2];
        Double price = Double.parseDouble(objectCsv[3]);
        return new Ticket(event, ticketType, price);
    }
}
