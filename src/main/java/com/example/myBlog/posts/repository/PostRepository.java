package com.example.myBlog.posts.repository;

import com.example.myBlog.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}