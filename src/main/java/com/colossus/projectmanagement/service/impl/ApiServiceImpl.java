package com.colossus.projectmanagement.service.impl;

import com.colossus.projectmanagement.entity.Project;
import com.colossus.projectmanagement.repository.ProjectRepository;
import com.colossus.projectmanagement.service.ApiService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiServiceImpl implements ApiService {

    private final ProjectRepository repository;

    public ApiServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getPreviousMonthReport() {
        System.out.println("the report is forming");

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) - 1; // previous month

        List<Project> list = repository.findAll().stream()
                .filter(Project::getFinished)
                .filter(project -> project.getDateOfFinishing().getYear()+1900 == year )
                .filter(project -> project.getDateOfFinishing().getMonth() == month)
                .collect(Collectors.toList());

        double summ = 0;

        StringBuilder builder = new StringBuilder();

        for (Project p: list) {
            summ+= p.getCosts();
            builder.append(p.getName()).append(" | ").append(p.getCosts()).append("\n");
        }
        builder.append("\nTotal: ").append(summ).append(" | Dividends: ").append(summ/5);

        return builder.toString();
    }
}
