package com.colossus.projectmanagement.service.impl;

import com.colossus.projectmanagement.entity.Project;
import com.colossus.projectmanagement.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectServiceImplTest {

    private final String NAME = "name";
    private final double WASTED = 25.5;
    private final String DESCRIPTION = "description";
    private final Date CREATION = new Date(50,Calendar.APRIL,17);
    private final String TAGS = "hard smart money";
    private final String PATH = "/iceberg/db";
    private final double COSTS = 75.6;

    @Autowired
    private ProjectService service;

    @Test
    void saveProject() {
        Project toSave = createProject();

        Project fromDB = service.saveProject(toSave);

        assertEquals(NAME, fromDB.getName());
        assertEquals(WASTED, fromDB.getWastedDays());
        assertEquals(DESCRIPTION, fromDB.getDescription());
        assertEquals(CREATION, fromDB.getDateOfCreation());
        assertEquals(TAGS, fromDB.getTags());
        assertEquals(PATH, fromDB.getDbPath());
        assertEquals(COSTS, fromDB.getCosts());

    }

    @Test
    void getAllProjects() {
        List<Project> list = service.getAllProjects();
        assertEquals(1, list.size());
    }

    @Test
    void getProjectById() {
        Project fromDB = service.getProjectById(1);

        assertEquals(1, fromDB.getId());
        assertEquals("na", fromDB.getName());
        assertEquals(2.5, fromDB.getWastedDays());
        assertEquals("desc", fromDB.getDescription());
        assertEquals(new Date(48,Calendar.JUNE, 20), fromDB.getDateOfCreation());
        assertEquals("ta", fromDB.getTags());
        assertEquals("pa", fromDB.getDbPath());
        assertEquals(85.7, fromDB.getCosts());
    }

    @Test
    void updateProject() {

        Project simple = createProject();
        service.saveProject(simple);

        Project forUpdateProject = new Project("na", 2.5, "desc", new Date(48,Calendar.JUNE, 20), "ta", "pa", 85.7);
        forUpdateProject.setId(1);

        Project updatedProject = service.updateProject(forUpdateProject);

        assertEquals(1, updatedProject.getId());
        assertEquals("na", updatedProject.getName());
        assertEquals(2.5, updatedProject.getWastedDays());
        assertEquals("desc", updatedProject.getDescription());
        assertEquals(new Date(48,Calendar.JUNE, 20), updatedProject.getDateOfCreation());
        assertEquals("ta", updatedProject.getTags());
        assertEquals("pa", updatedProject.getDbPath());
        assertEquals(85.7, updatedProject.getCosts());
    }

    @Test
    void deleteProjectById() {
        service.deleteProjectById(1);
        List<Project> list = service.getAllProjects();
        assertEquals(0, list.size());
    }

    Project createProject(){
        return new Project(NAME,WASTED,DESCRIPTION,CREATION,TAGS,PATH,COSTS);
    }
}