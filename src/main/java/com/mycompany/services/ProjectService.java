package com.mycompany.services;

import com.mycompany.exceptions.ProjectIdException;
import com.mycompany.model.Project;
import com.mycompany.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate (Project project){
        try {
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIdException("Project ID" +project.getProjectIdentifier()+" already exists");
        }
    }
    public Project findProjectByIdentifier(String projectId){
       Project project =  projectRepository.findByProjectIdentifier(projectId.toUpperCase(Locale.ROOT));
       if(project == null){
           throw new ProjectIdException("Project Id" +projectId.toUpperCase(Locale.ROOT)+ " does not exist! ");
       }
       else {
           return project;
       }
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if(project == null){
            throw new ProjectIdException("Project Id'" +projectId.toUpperCase(Locale.ROOT)+ "' does not exist! ");
        }
        else {
           projectRepository.delete(project);
        }

    }
}
