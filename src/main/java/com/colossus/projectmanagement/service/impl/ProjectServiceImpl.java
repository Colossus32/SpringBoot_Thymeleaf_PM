package com.colossus.projectmanagement.service.impl;

import com.colossus.projectmanagement.entity.DTO.ProjectDTO;
import com.colossus.projectmanagement.entity.Project;
import com.colossus.projectmanagement.repository.ProjectRepository;
import com.colossus.projectmanagement.service.ProjectService;
import com.colossus.projectmanagement.util.ProjectConverter;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    //sorting by newest
    @Override
    public List<Project> getAllProjects() {
        return repository.findAll().stream()
                .sorted(((o1, o2) -> o2.getDateOfCreation().compareTo(o1.getDateOfCreation())))
                .collect(Collectors.toList());
    }

    @Override
    public Project saveProject(Project project) {
        return repository.save(project);
    }

    @Override
    public Project getProjectById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Project updateProject(Project project) {
        return repository.save(project);
    }

    @Override
    public void deleteProjectById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProjectDTO> getReport() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        return repository.findAll().stream()
                .filter(Project::getFinished)
                .filter(project -> project.getDateOfFinishing().getYear()+1900 == year )
                .filter(project -> project.getDateOfFinishing().getMonth() == month)
                .map(ProjectConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
