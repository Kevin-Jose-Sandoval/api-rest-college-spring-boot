package com.api.apirestcollegue.repositories;

import com.api.apirestcollegue.models.CourseModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CourseRepository extends CrudRepository<CourseModel, Integer>{
    
    // getCoursesByStudentId
    @Query(value = "SELECT c.id, c.name, c.instructor_id FROM course c " +
            "INNER JOIN student_course sc ON c.id = sc.course_id " +
            "INNER JOIN student s ON s.id = sc.student_id " +
            "WHERE s.id = :id", nativeQuery = true)
    List<CourseModel> getCoursesByStudentId(@Param("id") Integer id);    
}
