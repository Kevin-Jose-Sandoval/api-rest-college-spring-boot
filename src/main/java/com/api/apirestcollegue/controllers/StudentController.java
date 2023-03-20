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
import org.springframework.dao.DataAccessException;
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
    public ResponseEntity<?> getAllStudents() {
        Map<String, Object> response = new HashMap<>();
        List<StudentModel> result = studentService.getAllStudents();
        

        response.put("message", "Request successfully");
        response.put("data", result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}")
    public List<ContactInfoStudentByIdDto> getContactInfoStudentById(@PathVariable Integer id) {
        return studentService.getContactInfoStudentById(id);
    }

    @PostMapping(value = "/students/add-course")
    public ResponseEntity<?> addCourseToStudent(@RequestBody StudentCourseDto dto) {
        Map<String, Object> response = new HashMap<>();

        try {
            CourseModel course = courseService.getCourseById(dto.getCourseId());
            StudentModel student = studentService.getStudentById(dto.getStudentId());

            course.getStudents().add(student);
            student.getCourses().add(course);

            studentService.addCourseToStudent(course, student);

            response.put("message", "Course added successfully");
            response.put("data", "");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            response.put("message", "Error to add course");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
