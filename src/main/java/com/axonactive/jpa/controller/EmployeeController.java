package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.enumerate.Gender;
import com.axonactive.jpa.service.EmployeeService;
import com.axonactive.jpa.service.impl.EmployeeServiceImpl;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/departments/{departmentId}/employees")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
    @Inject
    EmployeeService employeeService;

    @GET
    @Path("/{id}")
    public Response getEmployeeBuId(@PathParam("id") int id){
        return Response.ok(employeeService.getEmployeeById(id)).build();
    }

    @GET
    public Response getAllEmployeeByDepartmentId(@PathParam("departmentId") int departmentId) {
        return Response.ok(employeeService.getAllEmployeeByDepartmentId(departmentId)).build();
    }

    @GET
    @Path("/search")
    public Response getAllEmployeeByGender(@QueryParam("gender") Gender gender) {
        return Response.ok(employeeService.getAllEmployeeByGender(gender)).build();
    }

    @GET
    @Path("/search-age")
    public Response getAllEmployeeByGender(@QueryParam("age") int age) {
        return Response.ok(employeeService.getAllEmployeeByAge(age)).build();
    }

    @POST
    public Response addEmployee(@PathParam("departmentId") int departmentId, EmployeeRequest employeeRequest){
        return Response.ok(employeeService.addEmployee(departmentId, employeeRequest)).build();
    }

    @PUT
    @Path("/{employeeId}")
    public Response updateEmployee( @PathParam("employeeId") int employeeId, EmployeeRequest employeeRequest){
        return Response.ok(employeeService.updateEmployee(employeeId, employeeRequest)).build();
    }



}
