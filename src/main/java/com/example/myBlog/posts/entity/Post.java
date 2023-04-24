package com.example.myBlog.posts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Entity
public class Post {

    // 번호
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목
    @Setter
    private String title;

    // 내용
    @Setter

    @Column(columnDefinition = "TEXT")
    private String body;

    // 차후
    // 누가 썼는지

    // 언제 썼는지
    private LocalDateTime createdAt = LocalDateTime.now();    // 언제 수정되었는지
    private LocalDateTime updatedAt = LocalDateTime.now();
    public static Post createPost(String title, String body) {

        Post post = new Post();

        post.title = title;
        post.body = body;

        return post;

    }

}