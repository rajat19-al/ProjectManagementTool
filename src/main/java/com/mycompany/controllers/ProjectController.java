package com.mycompany.controllers;

import com.mycompany.model.Project;
import com.mycompany.services.ProjectService;
import com.mycompany.services.ValidationService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/save")
    public ResponseEntity<?> createNewProject(@RequestBody @Valid Project project, BindingResult result){
    ResponseEntity<?> errorMap = validationService.mapValidationService(result);
    if(errorMap!=null)
        return errorMap;

        Project proj = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(proj, HttpStatus.CREATED);
    }
}
