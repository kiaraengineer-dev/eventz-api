package com.eventz.eventz_api.dto;

import com.eventz.eventz_api.entity.EventProvider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventResponse {

    private Long id;
    private String title;
    
    private String description;
    private String location;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String category;
    private String imageUrl;
    private BigDecimal price;
    private Integer availableTickets;
    private Integer totalTickets;
    private EventProvider provider;
    private String purchaseUrl;

    

    public EventResponse() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public LocalDate getEventDate() {
        return eventDate;
    }


    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }


    public LocalTime getEventTime() {
        return eventTime;
    }


    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Integer getAvailableTickets() {
        return availableTickets;
    }


    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }


    public Integer getTotalTickets() {
        return totalTickets;
    }


    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public EventProvider getProvider() {
    return provider;
}

public void setProvider(EventProvider provider) {
    this.provider = provider;
}

public String getPurchaseUrl() {
    return purchaseUrl;
}

public void setPurchaseUrl(String purchaseUrl) {
    this.purchaseUrl = purchaseUrl;
}
       
    
}
