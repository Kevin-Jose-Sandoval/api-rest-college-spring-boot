package com.api.apirestcollegue.services;

import com.api.apirestcollegue.models.CourseModel;
import com.api.apirestcollegue.repositories.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseModel> getAllCourses() {
        return (List<CourseModel>) courseRepository.findAll();
    }

    public List<CourseModel> getCoursesByStudentId(Integer id) {
        return courseRepository.getCoursesByStudentId(id);
    }

    public CourseModel saveCourse(CourseModel courseModel) {
        return courseRepository.save(courseModel);
    }

    public CourseModel getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }
}
