package com.api.apirestcollegue.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactInfoStudentByIdDto {
    
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public ContactInfoStudentByIdDto(String firstName, String lastName, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    

}
