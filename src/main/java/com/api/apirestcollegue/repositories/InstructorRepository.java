package com.api.apirestcollegue.repositories;

import com.api.apirestcollegue.models.InstructorModel;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<InstructorModel, Integer>{
    
}
