package com.example.blogs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String introduction;
    @Column(columnDefinition = "LongText")
    private String content;
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
