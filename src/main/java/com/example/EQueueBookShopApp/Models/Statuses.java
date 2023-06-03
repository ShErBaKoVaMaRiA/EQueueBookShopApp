package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;
//Класс модели таблицы статусов
@Entity
@Table(name="Table_Status")
public class Statuses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Status")
    private Long UID;

    @Column(name = "Namestatus")
    private String name;

    public Statuses(String name) {
        this.name = name;
    }
    public Statuses() {
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
}
