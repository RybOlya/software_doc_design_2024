package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.model.Order;
import ua.lviv.iot.service.EventService;
import ua.lviv.iot.service.OrderService;

@Controller
public class EventController extends AbstractController<Event>{
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        super(eventService);
        this.eventService = eventService;
    }

    @GetMapping(path = "/event")
    public String getAllEvents(Model model) {
        model.addAttribute("event", eventService.findAll());
        return "event";
    }

    @GetMapping(path = "/showNewEventForm")
    public String showNewEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "create_event";
    }

    @GetMapping(path = "/showUpdateEventForm/{id}")
    public String showUpdateEventForm(@PathVariable("id") Integer eventId, Model model) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        return "update_event";
    }

    @PostMapping(path = "/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.saveToDatabase(event);
        return "redirect:/event";
    }

    @GetMapping(path = "/deleteEvent/{id}")
    public String deleteEvent(@PathVariable("id") Integer id) {
        eventService.deleteById(id);
        return "redirect:/event";
    }
}
