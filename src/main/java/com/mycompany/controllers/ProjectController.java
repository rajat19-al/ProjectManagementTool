package com.mycompany.controllers;

import com.mycompany.model.Project;
import com.mycompany.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public ResponseEntity<?> createNewProject(@RequestBody @Valid Project project, BindingResult result){
        if(result.hasErrors())
            return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);


        Project proj = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(proj, HttpStatus.CREATED);
    }
}
