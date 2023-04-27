package com.example.myBlog.posts.controller;

import com.example.myBlog.posts.dto.PostWriteDto;
import com.example.myBlog.posts.dto.PostWriteRequest;
import com.example.myBlog.posts.entity.Post;
import com.example.myBlog.posts.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    @ResponseBody
    public List<Post> getPostList() {
        List<Post> postList = postService.findAll();
        return postList;
    }

    @GetMapping("/write")
    public String getPostWriteView() {
        return "/posts/post_write";
    }

    @ResponseBody
    @PostMapping("/write")
    public PostWriteDto postWrite(
            @RequestBody @Valid PostWriteRequest postWriteRequest
    ) {

        System.out.println("postWriteRequest.getTitle() = " + postWriteRequest.getTitle());

        Long savedId = postService.save(postWriteRequest.getTitle(), postWriteRequest.getBody());
        PostWriteDto postWriteDto = new PostWriteDto(savedId);

        return postWriteDto;

    }

    @GetMapping("/{id}")
    public String getPost(
            @PathVariable Long id,
            Model model
    ) {
        Post findPost = postService.getById(id);

        model.addAttribute("post", findPost); // Map<String, Object>
        return "/posts/post_detail";
    }

}