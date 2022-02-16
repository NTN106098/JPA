package com.axonactive.jpa.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class DepartmentRequest {
    @NotNull
    private  String name;
    private LocalDate startDate;
}

