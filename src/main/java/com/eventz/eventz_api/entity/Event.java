package com.eventz.eventz_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    

    
    @Column(nullable = false)
    private String title;

    
    @Column(length = 3000)
    private String description;

   
    @Column(nullable = false)
    private String location;

    
    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private LocalTime eventTime;

    @Column(nullable = false)
    private String category;

    private String imageUrl;

    private BigDecimal price;

    private Integer totalTickets;

    private Integer availableTickets;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventProvider provider;

    private String purchaseUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;



    public Event() {
    }

    @PrePersist
    public void prePersist() {

        createdAt = LocalDateTime.now();

        if (provider == EventProvider.EVENTZ &&
                availableTickets == null &&
                totalTickets != null) {

            availableTickets = totalTickets;
        }

    }


    public Long getId() {
        return id;

    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public EventProvider getProvider() {
        return provider;
    }

    public String getPurchaseUrl() {
        return purchaseUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void setProvider(EventProvider provider) {
        this.provider = provider;
    }

    public void setPurchaseUrl(String purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }

}
