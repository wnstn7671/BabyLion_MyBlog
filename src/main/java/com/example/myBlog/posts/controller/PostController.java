package com.example.myBlog.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @GetMapping("/posts/write")
    public String getPostWriteView()
    {
        return "posts/post_write";
    }
    @PostMapping("/posts/write")
    public String postWrite(
            String title, String body
    ) {
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "redirect:/";
    }
    //
    // HTTP Method
    // GET, POST

}
