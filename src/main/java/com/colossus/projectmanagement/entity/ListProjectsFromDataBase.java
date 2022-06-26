package com.colossus.projectmanagement.entity;

import lombok.Data;

import java.util.List;

@Data
public class ListProjectsFromDataBase {
    private List<Project> list;
}
