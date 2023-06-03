package com.example.EQueueBookShopApp.Models;


import jakarta.persistence.*;
//Класс модели таблицы мероприятий
@Entity
@Table(name="Table_Events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Event")
    private Long UID;
    @Column(name="Nameevent")
    private String name;
    @Column(name="Datebeginevent")
    private String dateBegin;

    @JoinColumn(name = "Placeevent_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Eve__Place__5EBF139D"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private BookShops bookShops;
    @Column(name="Quantityofpeople")
    private Long quantityOfPeople;
    @Column(name="Imageevent")
    private String imageEvent;

    public Events() {
    }

    public Events(String name, String dateBegin, BookShops bookShops, Long quantityOfPeople, String imageEvent) {
        this.name = name;
        this.dateBegin = dateBegin;
        this.bookShops = bookShops;
        this.quantityOfPeople = quantityOfPeople;
        this.imageEvent = imageEvent;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public BookShops getBookShops() {
        return bookShops;
    }

    public void setBookShops(BookShops bookShops) {
        this.bookShops = bookShops;
    }

    public Long getQuantityOfPeople() {
        return quantityOfPeople;
    }

    public void setQuantityOfPeople(Long quantityOfPeople) {
        this.quantityOfPeople = quantityOfPeople;
    }

    public String getImageEvent() {
        return imageEvent;
    }

    public void setImageEvent(String imageEvent) {
        this.imageEvent = imageEvent;
    }
}
