package com.api.apirestcollegue.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instructor")
public class InstructorModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private Set<CourseModel> courses = new HashSet<>();
    
    public InstructorModel() {
    }

    public InstructorModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
