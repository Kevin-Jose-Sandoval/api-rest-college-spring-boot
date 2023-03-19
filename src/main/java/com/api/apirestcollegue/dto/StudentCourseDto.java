package com.api.apirestcollegue.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentCourseDto {
    
    private Integer studentId;
    private Integer courseId;

    public StudentCourseDto() {
    }

    public StudentCourseDto(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
    
}
