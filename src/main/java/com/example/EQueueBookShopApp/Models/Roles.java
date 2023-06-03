package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;
//Класс модели таблицы ролей
@Entity
@Table(name="Table_Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Role")
    private Long UID;

    @Column(name = "Namerole")
    private String name;

    public Roles(String name) {
        this.name = name;
    }


    public Roles() {
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