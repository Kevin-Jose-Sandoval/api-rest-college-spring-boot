package com.api.apirestcollegue.repositories;

import com.api.apirestcollegue.dto.ContactInfoStudentByIdDto;
import com.api.apirestcollegue.models.StudentModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<StudentModel, Integer>{
        
    // getContactInfoStudentById
    @Query("SELECT new com.api.apirestcollegue.dto.ContactInfoStudentByIdDto"
            + "(s.firstName, s.lastName, ci.address, ci.email) FROM StudentModel s "
            + "INNER JOIN ContactInfoModel ci on ci.id = s.id where s.id = ?1")
    List<ContactInfoStudentByIdDto> getContactInfoStudentById(Integer id);
    
}
