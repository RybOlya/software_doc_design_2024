package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.repository.EventRepository;

import java.util.Date;

@Service
public class EventService extends AbstractService<Event> {
    @Autowired
    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }

    @Override
    public Event mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        String eventName = objectCsv[1];
        String eventDate = objectCsv[2];
        String venue = objectCsv[3];

        return new Event(eventName, eventDate, venue);
    }
}
