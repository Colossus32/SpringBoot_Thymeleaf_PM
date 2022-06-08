package com.colossus.projectmanagement.service.impl;

import com.colossus.projectmanagement.entity.Project;
import com.colossus.projectmanagement.repository.ProjectRepository;
import com.colossus.projectmanagement.service.ProjectService;
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
    public String getReport() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR) + 1900;
        //int month = calendar.get(Calendar.MONTH);

        StringBuilder result = new StringBuilder("");

        repository.findAll().stream()
                .filter(project -> project.getDateOfCreation().getYear() == year)
                //.filter(project -> project.getDateOfCreation().getMonth() == month)
                .forEach(project -> result.append(project.getId()).append(" ").append(project.getName()).append("\n"));

        return "result.toString()";
    }
}
