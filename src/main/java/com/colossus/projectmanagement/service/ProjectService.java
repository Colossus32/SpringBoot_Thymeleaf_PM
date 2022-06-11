package com.colossus.projectmanagement.service;

import com.colossus.projectmanagement.entity.DTO.ProjectDTO;
import com.colossus.projectmanagement.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project saveProject(Project project);
    Project getProjectById(long id);
    Project updateProject(Project project);
    void deleteProjectById(long id);
    List<ProjectDTO> getReport();
}
