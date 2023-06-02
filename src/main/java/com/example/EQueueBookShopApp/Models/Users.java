package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Table_Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_User")
    private Long UID;
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message="Неверный формат")
    @NotEmpty(message =  "Поле не может быть пустым")
    @Column(name="Emailuser")
    private String email;
    @Pattern(regexp = "^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&?.,_ \"]).*$",message="Неверный формат")
//    @NotEmpty(message =  "Поле не может быть пустым")
    @Column(name="Passworduser")
    private String password;

    @JoinColumn(name = "Role_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Use__Role___440B1D61"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Roles roles;
    @NotEmpty(message =  "Поле не может быть пустым")
    @Column(name="Surnameuser")
    private String surname;
    @NotEmpty(message =  "Поле не может быть пустым")
    @Column(name="Nameuser")
    private String name;
    @Column(name="Middlenameuser")
    private String middlename;

    @Column(name="Consentpersonaldata")
    private String personalData;

    public Users(String email, String password, Roles roles, String surname, String name, String middlename, String personalData) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.personalData = personalData;
    }
    public Users() {
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }
}
