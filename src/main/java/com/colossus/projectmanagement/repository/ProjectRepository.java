package com.colossus.projectmanagement.repository;

import com.colossus.projectmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {

}
