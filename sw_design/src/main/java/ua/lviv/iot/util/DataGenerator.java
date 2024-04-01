package ua.lviv.iot.util;

import com.opencsv.CSVWriter;
import org.jeasy.random.EasyRandom;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static void main(String[] args) throws IOException {
        List<String[]> data = new ArrayList<>();

        generateUserData(data);
        generateEventData(data);
        generateTicketData(data);
        generateOrderData(data);

        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            writer.writeAll(data);
        }
    }

    private static void generateUserData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<User> users = generator.objects(User.class, 500).toList();

        for (User user : users) {
            data.add(user.toCsvFormat());
        }
    }

    private static void generateEventData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Event> events = generator.objects(Event.class, 500).toList();

        for (Event event : events) {
            data.add(event.toCsvFormat());
        }
    }

    private static void generateTicketData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Ticket> tickets = generator.objects(Ticket.class, 500).toList();

        for (Ticket ticket : tickets) {
            data.add(ticket.toCsvFormat());
        }
    }


    private static void generateOrderData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Order> orders = generator.objects(Order.class, 500).toList();

        for (Order order : orders) {
            data.add(order.toCsvFormat());
        }
    }
}
