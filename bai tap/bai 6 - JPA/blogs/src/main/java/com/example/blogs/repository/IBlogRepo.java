package com.example.blogs.repository;

import com.example.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    @Query(nativeQuery = true, value = "select * from blog where title like :search and (:id = 0 or category_id = :id)")
    Page<Blog> findAll(@Param("search") String name, @Param("id") int categoryId, Pageable pageable);
}
