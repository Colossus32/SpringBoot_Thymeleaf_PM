package com.colossus.projectmanagement.controller;

import com.colossus.projectmanagement.entity.Project;
import com.colossus.projectmanagement.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping("/projects")
    public String listOfProjects(Model model){
        model.addAttribute("projects", service.getAllProjects());
        return "projects";
    }

    @GetMapping("/projects/new")
    public String creatingProjectForm(Model model){

        //Create project object for the form
        model.addAttribute("project", new Project());
        return "create_project";
    }

    @PostMapping("/projects")
    public String saveProject(@ModelAttribute("project") Project project){

        service.saveProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/edit/{id}")
    public String editingProjectForm(@PathVariable long id, Model model){

        model.addAttribute("project", service.getProjectById(id));
        return "edit_project";
    }

    @PostMapping("/projects/{id}")
    public String updateProject(@PathVariable long id,
                                @ModelAttribute("project") Project project,
                                Model model){

        //at first get a project from DB with this id
        Project projectFromDB = service.getProjectById(id);
        //rewrite it
        projectFromDB.setId(id);
        projectFromDB.setName(project.getName());
        projectFromDB.setWastedDays(project.getWastedDays());
        projectFromDB.setDescription(project.getDescription());
        //save it to DB
        service.updateProject(projectFromDB);

        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String deleteProject(@PathVariable long id){

        service.deleteProjectById(id);
        return "redirect:/projects";
    }
}
