package com.eventz.eventz_api.service;

import com.eventz.eventz_api.dto.CreateEventRequest;
import com.eventz.eventz_api.dto.EventResponse;
import com.eventz.eventz_api.dto.UpdateEventRequest;
import com.eventz.eventz_api.entity.Event;
import com.eventz.eventz_api.entity.EventProvider;
import com.eventz.eventz_api.repository.EventRepository;
import com.eventz.eventz_api.repository.UserRepository;


import com.eventz.eventz_api.entity.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;
    


    public EventResponse createEvent(CreateEventRequest request) {

         Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();

    String email = authentication.getName();

    User user = userRepository.findByEmail(email)
    .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Event event = new Event();

          event.setUser(user);

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setEventTime(request.getEventTime());
        event.setCategory(request.getCategory());
        event.setImageUrl(request.getImageUrl());
        event.setPrice(request.getPrice());
        event.setTotalTickets(request.getTotalTickets());

        event.setProvider(EventProvider.EVENTZ);

        event.setPurchaseUrl(null);

        Event savedEvent = eventRepository.save(event);

        return toResponse(savedEvent);
    }

    

    public List<EventResponse> getAllEvents() {

        return eventRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<EventResponse> getMyEvents() {

     Authentication authentication =
         SecurityContextHolder.getContext().getAuthentication();

    String email = authentication.getName();

    User user = userRepository.findByEmail(email)
     .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
       
        return eventRepository.findByUserId(user.getId())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    

    public EventResponse getEventById(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Evento não encontrado."));

        return toResponse(event);
    }

  

    public EventResponse updateEvent(Long id, UpdateEventRequest request) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Evento não encontrado."));

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setEventTime(request.getEventTime());
        event.setCategory(request.getCategory());
        event.setImageUrl(request.getImageUrl());
        event.setPrice(request.getPrice());
        event.setTotalTickets(request.getTotalTickets());

        Event updatedEvent = eventRepository.save(event);

        return toResponse(updatedEvent);
    }


    public void deleteEvent(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Evento não encontrado."));

        eventRepository.delete(event);
    }

   

    private EventResponse toResponse(Event event) {

        EventResponse response = new EventResponse();

        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setLocation(event.getLocation());
        response.setEventDate(event.getEventDate());
        response.setEventTime(event.getEventTime());
        response.setCategory(event.getCategory());
        response.setImageUrl(event.getImageUrl());
        response.setPrice(event.getPrice());
        response.setAvailableTickets(event.getAvailableTickets());
        response.setProvider(event.getProvider());
        response.setPurchaseUrl(event.getPurchaseUrl());

        return response;
    }
}


