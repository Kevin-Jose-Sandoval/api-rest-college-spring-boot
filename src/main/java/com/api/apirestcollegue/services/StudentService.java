package com.api.apirestcollegue.services;

import com.api.apirestcollegue.dto.ContactInfoStudentByIdDto;
import com.api.apirestcollegue.models.CourseModel;
import com.api.apirestcollegue.models.StudentModel;
import com.api.apirestcollegue.repositories.CourseRepository;
import com.api.apirestcollegue.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<StudentModel> getAllStudents() {
        return (List<StudentModel>) studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ContactInfoStudentByIdDto> getContactInfoStudentById(Integer id) {
        return studentRepository.getContactInfoStudentById(id);
    }

    @Transactional(readOnly = true)
    public StudentModel getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addCourseToStudent(CourseModel course, StudentModel student) {
        courseRepository.save(course);
        studentRepository.save(student);
    }
}
