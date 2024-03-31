package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Event;
import ua.lviv.iot.service.EventService;

@Controller
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "events";
    }

    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "create_event";
    }

    @GetMapping("/showUpdateEventForm/{id}")
    public String showUpdateEventForm(@PathVariable("id") Integer eventId, Model model) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);
        return "update_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.saveToDatabase(event);
        return "redirect:/events";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable("id") Integer id) {
        eventService.deleteById(id);
        return "redirect:/events";
    }
}
