package com.axonactive.jpa.entities;

import com.axonactive.jpa.enumerate.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "department_location")
public class DepartmentLocation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    @Enumerated(EnumType.STRING)
    private Location location;

}
