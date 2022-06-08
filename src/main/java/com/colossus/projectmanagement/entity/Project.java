package com.colossus.projectmanagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double wastedDays;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfCreation;

    private String tags;

    private String dbPath;

    private double costs;

    public Project() {
    }

    public Project(String name, double wastedDays, String description, Date dateOfCreation, String tags, String dbPath, double costs) {
        this.name = name;
        this.wastedDays = wastedDays;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.tags = tags;
        this.dbPath = dbPath;
        this.costs = costs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWastedDays() {
        return wastedDays;
    }

    public void setWastedDays(double wastedDays) {
        this.wastedDays = wastedDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreaation) {
        this.dateOfCreation = dateOfCreaation;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }
}
