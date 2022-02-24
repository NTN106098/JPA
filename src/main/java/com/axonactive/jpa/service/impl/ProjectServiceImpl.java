package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.entities.Project;
import com.axonactive.jpa.service.DepartmentService;
import com.axonactive.jpa.service.ProjectService;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Getter
@Setter

public class ProjectServiceImpl implements ProjectService {

   @PersistenceContext(unitName = "jpademo")
   private EntityManager em;
    @Inject
    DepartmentService departmentService;
    @Override
    public Project getProjectById(int id) {
        Query query = em.createQuery("SELECT p FROM Project p WHERE p.id = :id");
//        return em.find(Project.class, id);
        query.setParameter("id", id);
        return (Project) query.getSingleResult();
    }

    @Override
    public List<Project> getAllProjectDepartmentById(int departmentId) {
        Query query = em.createQuery("SELECT p FROM Project p WHERE p.department.id = :departmentId");
        query.setParameter("departmentId", departmentId);
        return (List<Project>) query.getResultList();
    }


    @Override
    public Project addProject(int departmentId, ProjectRequest projectRequest) {
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setArea(projectRequest.getArea());

        Department department = departmentService.getDepartmentById(departmentId);
        project.setDepartment(department);
        em.persist(project);
        return  project;
    }

    @Override
    public Project updateProject( int projectId, ProjectRequest projectRequest) {
        Project project = getProjectById(projectId);
        project.setName(projectRequest.getName());
        project.setArea(projectRequest.getArea());
        em.merge(project);
        return  project;
    }

    //    @Override
//    public Project updateProject(int departmentId, int projectId, ProjectRequest projectRequest) {
//        return null;
//    }
//
//



}
