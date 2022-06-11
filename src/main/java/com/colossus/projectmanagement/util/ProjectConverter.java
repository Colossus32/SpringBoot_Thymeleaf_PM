package com.colossus.projectmanagement.util;

import com.colossus.projectmanagement.entity.DTO.ProjectDTO;
import com.colossus.projectmanagement.entity.Project;

public class ProjectConverter {

    public static ProjectDTO convertToDTO(Project project){
        return new ProjectDTO(project.getId(),
                project.getName(),
                project.getCosts(),
                project.getWastedDays(),
                project.getDateOfFinishing());
    }
}
