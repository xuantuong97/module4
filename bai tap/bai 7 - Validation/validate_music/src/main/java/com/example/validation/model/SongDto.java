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
public class SongDto implements Validator {
    @Max(value = 800, message = "Not over 800 character")
    private String songName;
    @Max(value = 300, message = "Not over 300 character")
    private String singerName;
    @Max(value = 1000, message = "Not over 1000 character")
    private String musicType;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if("".equals(songDto.songName.trim())){
            errors.rejectValue("songName", null, "Not allow empty");
        }
        else if(!songDto.songName.matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("songName", null, "Not contain special character");
        }
        else if("".equals(songDto.singerName.trim())){
            errors.rejectValue("songName", null, "Not allow empty");
        }
    }
}
