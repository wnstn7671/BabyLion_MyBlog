package com.example.myBlog.posts.controller;

import com.example.myBlog.posts.entity.Post;
import com.example.myBlog.posts.service.PostService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/write")
    public String getPostWriteView() {
        return "/posts/post_write";
    }
    @ResponseBody
    @PostMapping("/posts/write")
    public String postWrite(
            @NotBlank String title, String body
    ) {
       // Long savedId = postService.save(title, body);
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "redirect:/";
    }

    @GetMapping("/posts/{id}")
    public String getPost(
            @PathVariable Long id,
            Model model
    ) {
        Post findPost = postService.getById(id);

        model.addAttribute("post", findPost); // Map<String, Object>
        return "/posts/post_detail";
    }


}