package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;
//Класс модели таблицы типов обслуживания
@Entity
@Table(name="Table_Typesservice")
public class TypesService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Typeservice")
    private Long UID;

    @Column(name = "Nametypeservice")
    private String name;
}
