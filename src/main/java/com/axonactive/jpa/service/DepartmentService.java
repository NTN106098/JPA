package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartmentById(int id);
    Department addDepartment(DepartmentRequest department);
    List<Department> getAllDepartment();
    void deleteDepartment(int id);
    Department updateDepartment(int id, DepartmentRequest departmentRequest);
}
