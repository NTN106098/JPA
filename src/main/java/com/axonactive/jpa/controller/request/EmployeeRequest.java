package com.axonactive.jpa.controller.request;

import com.axonactive.jpa.entities.Department;
import com.axonactive.jpa.enumerate.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequest {
    @NotNull
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private double salary;
}
