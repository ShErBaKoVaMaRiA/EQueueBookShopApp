package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;
//Класс модели таблицы окон обслуживания
@Entity
@Table(name="Table_Windows")
public class Windows {
    @Id
    @Column(name="ID_Window")
    private Long UID;

    @JoinColumn(name = "Typeservicewindow_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Win__TypeS__47DBAE45"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private TypesService type;

    public Windows() {
    }

    public Windows(Long UID, TypesService type) {
        this.UID = UID;
        this.type = type;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public TypesService getType() {
        return type;
    }

    public void setType(TypesService type) {
        this.type = type;
    }
}
