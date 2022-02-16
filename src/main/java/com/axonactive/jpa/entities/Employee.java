package com.axonactive.jpa.entities;

import com.axonactive.jpa.enumerate.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = Employee.GET_BY_AGE, query = "SELECT e FROM Employee e WHERE e.dateOfBirth < :requestedYear"),
        @NamedQuery(name = Employee.GET_BY_GENDER, query = "SELECT e FROM Employee e WHERE e.gender = :gender")
}
)
public class Employee {
    private final static String QUALIFIED = "com.axonactive.jpa.entities";
    public final static String GET_BY_AGE = QUALIFIED + "getEmployeeByAge";
    public final static String GET_BY_GENDER = QUALIFIED + "getEmployeeByGender";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(20)")
    private String firstName;

    @Column(name = "middle_name", nullable = false, columnDefinition = "varchar(20)")
    @NotNull
    private String middleName;

    @Column(name = "last_name", nullable = false, columnDefinition = "varchar(20)")
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

}
