package com.example.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminBlogController {
    @GetMapping("/admin/blog")
    public String adminBlog(){
        return "admin/blog";
    }
}
