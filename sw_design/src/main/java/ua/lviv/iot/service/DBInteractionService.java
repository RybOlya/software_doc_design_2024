package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.model.User;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.repository.StorgeRepository;



import java.util.List;

@Service
public class DBInteractionService {
    @Autowired
    StorgeRepository repository;

    TicketService ticketService;
    UserService userService;
    OrderService orderService;
    EventService eventService;
    @Autowired
    public DBInteractionService(TicketService ticketService, UserService userService,
                           OrderService orderService, EventService eventService) {
        this.eventService = eventService;
        this.orderService = orderService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    public void dumpCsvToDB(String filepath) {
        List<String[]> data = repository.readAll(filepath);
        data.forEach(entry -> {
            switch (entry[0]) {
                case "USER" -> {
                    User user = userService.mapCsvToObject(entry);
                    userService.saveToDatabase(user);
                }
                case "EVENT" -> {
                    Event event = eventService.mapCsvToObject(entry);
                    eventService.saveToDatabase(event);
                }
                case "TICKET" -> {
                    Ticket ticket = ticketService.mapCsvToObject(entry);
                    ticketService.saveToDatabase(ticket);
                }
                case "ORDER" -> {
                    Order order = orderService.mapCsvToObject(entry);
                    orderService.saveToDatabase(order);
                }
            }
        });
    }
}