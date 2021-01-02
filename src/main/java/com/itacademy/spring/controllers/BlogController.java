package com.itacademy.spring.controllers;

import com.itacademy.spring.models.BlogPost;
import com.itacademy.spring.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<BlogPost> blogPosts = blogPostRepository.findAll();
        model.addAttribute("posts",blogPosts);
        return "blog-main";
    }

}
