package com.example.EQueueBookShopApp.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Table_Queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Count")
    private Long UID;
    @Column(name = "Numberclient")
    private String numberClient;
    @JoinColumn(name = "Client_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Que__Clien__6EF57B66"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Users client;
    @JoinColumn(name = "Status_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Que__Statu__6FE99F9F"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Statuses statuses;
    @Column(name = "Datetimebegin")
    private String dateBegin;
    @JoinColumn(name = "Typeservice_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Que__TypeS__71D1E811"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private TypesService typesService;
    @JoinColumn(name = "Window_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Que__Windo__72C60C4A"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Windows windows;
    @JoinColumn(name = "Employee_ID", nullable = false, foreignKey = @ForeignKey(name = "FK__Table_Que__Emplo__73BA3083"))
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Users employee;
    @Column(name = "Datetimeend")
    private String dateEnd;
    @Column(name = "Timeservice")
    private String timeService;
    @Column(name = "Assessment")
    private Long assessment;

    public Queue(String numberClient, Users client, Statuses statuses, String dateBegin, TypesService typesService, Windows windows, Users employee, String dateEnd, String timeService, Long assessment) {
        this.numberClient = numberClient;
        this.client = client;
        this.statuses = statuses;
        this.dateBegin = dateBegin;
        this.typesService = typesService;
        this.windows = windows;
        this.employee = employee;
        this.dateEnd = dateEnd;
        this.timeService = timeService;
        this.assessment = assessment;
    }

    public Queue() {
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(String numberClient) {
        this.numberClient = numberClient;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }

    public Statuses getStatuses() {
        return statuses;
    }

    public void setStatuses(Statuses statuses) {
        this.statuses = statuses;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public TypesService getTypesService() {
        return typesService;
    }

    public void setTypesService(TypesService typesService) {
        this.typesService = typesService;
    }

    public Windows getWindows() {
        return windows;
    }

    public void setWindows(Windows windows) {
        this.windows = windows;
    }

    public Users getEmployee() {
        return employee;
    }

    public void setEmployee(Users employee) {
        this.employee = employee;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTimeService() {
        return timeService;
    }

    public void setTimeService(String timeService) {
        this.timeService = timeService;
    }

    public Long getAssessment() {
        return assessment;
    }

    public void setAssessment(Long assessment) {
        this.assessment = assessment;
    }
}