
package com.api.apirestcollegue.services;

import com.api.apirestcollegue.models.InstructorModel;
import com.api.apirestcollegue.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    
    @Autowired
    private InstructorRepository instructorRepository;
    
    public InstructorModel getInstructorById(Integer id){
        return instructorRepository.findById(id).get();
    }

}
