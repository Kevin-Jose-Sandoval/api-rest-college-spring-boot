package com.api.apirestcollegue.controllers;

import com.api.apirestcollegue.dto.ContactInfoStudentByIdDto;
import com.api.apirestcollegue.dto.StudentCourseDto;
import com.api.apirestcollegue.models.CourseModel;
import com.api.apirestcollegue.models.StudentModel;
import com.api.apirestcollegue.services.CourseService;
import com.api.apirestcollegue.services.StudentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;
    
    @GetMapping(value = "/students")
    public List<StudentModel> getAllStudents(){
        
        return studentService.getAllStudents();
    }
    
    @GetMapping(value = "/students/{id}")
    public List<ContactInfoStudentByIdDto> getContactInfoStudentById(@PathVariable Integer id){
        return studentService.getContactInfoStudentById(id);
    }
    
    @PostMapping(value = "/students/add-course")
    public ResponseEntity<?> addCourseToStudent(@RequestBody StudentCourseDto dto){
        Map<String, Object> response = new HashMap<>();
        
        try {
            CourseModel course = courseService.getCourseById(dto.getCourseId());
            StudentModel student = studentService.getStudentById(dto.getStudentId());

            course.getStudents().add(student);
            student.getCourses().add(course);
            
            Boolean result = studentService.addCourseToStudent(course, student);
            
            if(!result) {
                response.put("message", "Error to add course");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            response.put("message", "Course added successfully");
            response.put("data", "");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
            
        } catch (Exception e) {
            response.put("message", "Error to add course");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
