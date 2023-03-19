package com.api.apirestcollegue.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    
    private String name;
    private Integer instructorId;

    public CourseDto() {
    }

    public CourseDto(String name, Integer instructorId) {
        this.name = name;
        this.instructorId = instructorId;
    }
}
