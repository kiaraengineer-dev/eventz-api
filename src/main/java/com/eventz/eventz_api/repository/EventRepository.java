package com.eventz.eventz_api.repository;

import com.eventz.eventz_api.entity.Event;
import com.eventz.eventz_api.entity.EventProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByUserId(Long userId);

    List<Event> findByProvider(EventProvider provider);

     

    List<Event> findByCategory(String category);

    List<Event> findByTitleContainingIgnoreCase(String title);

}
