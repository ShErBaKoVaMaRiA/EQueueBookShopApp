package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Table_Signupevents")
public class SignUpEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Signupevent")
    private Long UID;
    @JoinColumn(name = "Client_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Sig__Clien__6477ECF3"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Users client;
    @JoinColumn(name = "Event_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Sig__Event__656C112C"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Events events;

    public SignUpEvents() {
    }

    public SignUpEvents(Users client, Events events) {
        this.client = client;
        this.events = events;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}
