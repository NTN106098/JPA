package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.EmployeeRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Employee;
import com.axonactive.jpa.enumerate.Gender;
import com.axonactive.jpa.service.DepartmentService;
import com.axonactive.jpa.service.EmployeeService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext(unitName = "jpademo")
    private EntityManager em;
    @Inject
    DepartmentService departmentService;
    @Override
    public Employee getEmployeeById(int id) {
        return em.find(Employee.class,id);
    }

    @Override
    public List<Employee> getAllEmployeeByDepartmentId(int departmentId) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.department.id = :departmentId", Employee.class);
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }

    @Override
    public Employee addEmployee( int departmentId , EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setMiddleName(employeeRequest.getMiddleName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setSalary(employeeRequest.getSalary());

        Department department = departmentService.getDepartmentById(departmentId);
        employee.setDepartment(department);
        em.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(int employeeId, EmployeeRequest employeeRequest) {
        Employee employee = getEmployeeById(employeeId);
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setMiddleName(employeeRequest.getMiddleName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setSalary(employeeRequest.getSalary());

        em.merge(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployeeByGender(Gender gender) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.gender = :gender", Employee.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }

    private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> getAllEmployeeByAge(int age) {
        LocalDate requestedYear = LocalDate.now().minusYears(age);
        TypedQuery<Employee> query= em.createNamedQuery(Employee.GET_BY_AGE, Employee.class);
        query.setParameter("requestedYear", requestedYear);
        return query.getResultList();
    }


}
