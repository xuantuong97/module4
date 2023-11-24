package com.example.validation.model;


import jakarta.validation.constraints.*;
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
    private String songName;
    private String singerName;
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
        else if(songDto.songName.length()>800) {
            errors.rejectValue("songName", null, "The length must be smaller than 800");
        }
        else if(!songDto.songName.matches("^[a-zA-Z0-9 ]*$")){
            errors.rejectValue("songName", null, "Not contain special character");
        }
        else if("".equals(songDto.singerName.trim())){
            errors.rejectValue("singerName", null, "Not allow empty");
        }
        else if(songDto.singerName.length()>300) {
            errors.rejectValue("singerName", null, "The length must be smaller than 300");
        }
        else if(!songDto.singerName.matches("^[a-zA-Z0-9 ]*$")){
            errors.rejectValue("singerName", null, "Not contain special character");
        }
        else if("".equals(songDto.musicType.trim())) {
            errors.rejectValue("musicType", null, "Not allow empty");
        }
        else if(songDto.musicType.length()>1000) {
            errors.rejectValue("musicType", null, "The length must be smaller than 1000");
        }
        else if(!songDto.musicType.matches("^[a-zA-Z0-9, ]*$")){
            errors.rejectValue("musicType", null, "Not contain special character");
        }
    }
}
