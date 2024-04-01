package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.model.User;
import ua.lviv.iot.repository.OrderRepository;

import java.util.List;


@Service
public class OrderService extends AbstractService<Order> {
    private final UserService userService;
    private final TicketService ticketService;
    @Autowired
    public OrderService(OrderRepository orderRepository,  UserService userService,
                        TicketService ticketService) {
        super(orderRepository);
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public Order mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        List<User> listev = userService.findAll();
        User user = userService.getById(Integer.parseInt(objectCsv[1]));
        Ticket ticket = ticketService.getById(Integer.parseInt(objectCsv[2]));
        Integer quantity = Integer.parseInt(objectCsv[3]);
        String orderDate = objectCsv[3];
        return new Order(user, ticket, quantity, orderDate);
    }
}
