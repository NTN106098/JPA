package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Employee;
import com.axonactive.jpa.enumerate.Gender;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployeeByDepartmentId(int departmentId);
    Employee addEmployee(int departmentId, EmployeeRequest employeeRequest);
    Employee updateEmployee( int employeeId, EmployeeRequest employeeRequest);
    List<Employee> getAllEmployeeByGender(Gender gender);
    List<Employee> getAllEmployeeByAge(int age);
}
