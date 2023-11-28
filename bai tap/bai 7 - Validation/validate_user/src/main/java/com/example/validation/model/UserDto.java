package com.example.validation.model;


import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    @Email(message = "Not correct format")
    private String Email;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if("".equals(userDto.firstName.trim())){
            errors.rejectValue("firstName", null, "Not allow empty");
        }
        if(!(userDto.firstName.matches("^[A-Z][a-z]+") && (userDto.firstName.trim()).length()>=5)){
            errors.rejectValue("firstName", null, "Not correct format or not enough length");
        }
        if("".equals(userDto.lastName.trim())){
            errors.rejectValue("lastName", null, "Not allow empty");
        }
        if(!(userDto.lastName.matches("^[A-Z][a-z]+") && (userDto.lastName.trim().length()>=5))){
            errors.rejectValue("lastName", null, "Not correct format or not enough length");
        }
        if(!userDto.phoneNumber.matches("^0\\d{9}$")){
            errors.rejectValue("phoneNumber", null, "Not correct format");
        }
    }
}
