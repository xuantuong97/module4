package com.example.blogs.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private int id;
    private String title;
    private String introduction;
    private String content;
    private LocalDateTime createDate;
    private Category category;
}
