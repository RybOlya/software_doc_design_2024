package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.TicketDto;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.service.TicketService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/ticket")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<Ticket> tickets = ticketService.findAll();
        List<TicketDto> ticketDtos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketDto ticketDto = new TicketDto(ticket.getId(), ticket.getEvent().getId(),
                    ticket.getTicketType(), ticket.getPrice());
            ticketDtos.add(ticketDto);
        }
        return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable("id") Integer ticketId) {
        Ticket updatedTicket = ticketService.getById(ticketId);
        if (updatedTicket!=null) {
            TicketDto ticketDto = new TicketDto(updatedTicket.getId(), updatedTicket.getEvent().getId(),
                    updatedTicket.getTicketType(), updatedTicket.getPrice());
            return new ResponseEntity<>(ticketDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
