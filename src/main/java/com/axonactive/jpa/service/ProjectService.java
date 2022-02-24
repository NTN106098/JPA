package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.entities.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectById(int id);
    List<Project>getAllProjectDepartmentById(int departmentId);
    Project addProject(int departmentId, ProjectRequest projectRequest);
    Project updateProject(  int projectId, ProjectRequest projectRequest);


    //


    // Project updateProject(int projectId, ProjectRequest projectRequest);
}
