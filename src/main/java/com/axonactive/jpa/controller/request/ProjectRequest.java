package com.axonactive.jpa.controller.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProjectRequest {
    @NotNull
    private  String name;
    private  String area;

}
