package ua.lviv.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.lviv.iot.service.DBInteractionService;

@SpringBootApplication
public class TicketBookingApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TicketBookingApplication.class, args);
        context.getBean(DBInteractionService.class).dumpCsvToDB("data.csv");
    }
}