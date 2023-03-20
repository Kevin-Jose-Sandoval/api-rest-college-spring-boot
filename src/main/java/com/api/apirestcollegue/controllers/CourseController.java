package com.api.apirestcollegue.controllers;

import com.api.apirestcollegue.dto.CourseDto;
import com.api.apirestcollegue.models.CourseModel;
import com.api.apirestcollegue.models.InstructorModel;
import com.api.apirestcollegue.services.CourseService;
import com.api.apirestcollegue.services.InstructorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private InstructorService instructorService;
    
    @GetMapping(value = "/courses")
    public List<CourseModel> getAllCourses(){
        return courseService.getAllCourses();
    }
    
    @GetMapping(value = "/courses/{id}")
    public List<CourseModel> getCoursesByStudentId(@PathVariable Integer id){
        return courseService.getCoursesByStudentId(id);
    }
    
    @PostMapping(value = "/courses")
    public CourseModel saveCourse(@RequestBody CourseDto courseDto){
        InstructorModel instructor = instructorService.getInstructorById(courseDto.getInstructorId());

        CourseModel newCourse = new CourseModel();
        newCourse.setInstructor(instructor);
        newCourse.setName(courseDto.getName());
        
        return courseService.saveCourse(newCourse);
    }
}
