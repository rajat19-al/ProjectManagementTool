package com.mycompany.services;

import com.mycompany.model.Project;
import com.mycompany.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate (Project project){
        return projectRepository.save(project);
    }
}
