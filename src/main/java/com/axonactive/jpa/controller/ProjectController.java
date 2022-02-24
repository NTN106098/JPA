package com.axonactive.jpa.controller;


import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.service.ProjectService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/department/{departmentId}/projects")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
public class ProjectController {
    @Inject
    ProjectService projectService;

    @GET
    @Path("/{id}")
    public Response getProjectById(@PathParam("id") int id){
        return Response.ok(projectService.getProjectById(id)).build();
    }

    @GET
    public  Response getAllProjectDepartmentById(@PathParam("departmentId") int departmentId) {
        return  Response.ok(projectService.getAllProjectDepartmentById(departmentId)).build();
    }

    @POST
    public  Response addProject(@PathParam("departmentId") int departmentId, ProjectRequest projectRequest) {
        return  Response.ok(projectService.addProject(departmentId, projectRequest)).build();
    }


    @PUT
    @Path("/{projectId}")
    public  Response updateProject (@PathParam("projectId") int projectId,ProjectRequest projectRequest) {
        return Response.ok(projectService.updateProject(projectId,projectRequest)).build();
    }
}
