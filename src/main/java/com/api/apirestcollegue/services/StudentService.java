package com.api.apirestcollegue.services;

import com.api.apirestcollegue.dto.ContactInfoStudentByIdDto;
import com.api.apirestcollegue.models.CourseModel;
import com.api.apirestcollegue.models.StudentModel;
import com.api.apirestcollegue.repositories.CourseRepository;
import com.api.apirestcollegue.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<StudentModel> getAllStudents() {
        return (List<StudentModel>) studentRepository.findAll();
    }

    public List<ContactInfoStudentByIdDto> getContactInfoStudentById(Integer id) {
        return studentRepository.getContactInfoStudentById(id);
    }

    public StudentModel getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Boolean addCourseToStudent(CourseModel course, StudentModel student) {
        try {
            courseRepository.save(course);
            studentRepository.save(student);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
