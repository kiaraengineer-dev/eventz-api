
package com.eventz.eventz_api.controller;

import com.eventz.eventz_api.dto.CreateEventRequest;
import com.eventz.eventz_api.dto.EventResponse;
import com.eventz.eventz_api.dto.UpdateEventRequest;
import com.eventz.eventz_api.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping
    public EventResponse createEvent(
          @RequestBody CreateEventRequest request) {

        return eventService.createEvent(request);
    }


    @GetMapping
    public List<EventResponse> getAllEvents() {

        return eventService.getAllEvents();
    }

    @GetMapping("/my-events")
    public List<EventResponse> getMyEvents() {
    return eventService.getMyEvents();
}

    

    @GetMapping("/{id}")
    public EventResponse getEventById(
            @PathVariable Long id) {

        return eventService.getEventById(id);
    }


    @PutMapping("/{id}")
    public EventResponse updateEvent(
            @PathVariable Long id,
            @RequestBody UpdateEventRequest request) {

        return eventService.updateEvent(id, request);
    }


    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable Long id) {

        eventService.deleteEvent(id);
    }


}

