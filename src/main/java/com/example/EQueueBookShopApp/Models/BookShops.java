package com.example.EQueueBookShopApp.Models;


import jakarta.persistence.*;
//Класс модели таблицы книжных магазинов
@Entity
@Table(name="Table_Bookshops")
public class BookShops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Bookshop")
    private Long UID;

    @Column(name="Namebookshop")
    private String name;

    @Column(name="Addressbookshop")
    private String address;

    @Column(name="Phonebookshop")
    private String phone;

    public BookShops() {
    }

    public BookShops(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
