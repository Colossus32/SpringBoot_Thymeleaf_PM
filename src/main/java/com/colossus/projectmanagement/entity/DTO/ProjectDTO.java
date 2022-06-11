package com.colossus.projectmanagement.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class ProjectDTO {

    private long id;
    private String name;
    private double costs;
    private double wastedDays;
    private Date dateOfFinishing;
}
