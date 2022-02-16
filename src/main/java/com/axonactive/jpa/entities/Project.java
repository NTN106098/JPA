package com.axonactive.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String area;

    @ManyToOne
    @JoinColumn(name = "managed_department", referencedColumnName = "id")
    private Department department;

}
